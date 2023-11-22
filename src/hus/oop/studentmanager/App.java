package hus.oop.studentmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";
    private static final StudentManager studentManager = new StudentManager();

    public static void main(String[] args) {
        init();
        testOriginalData();
        testSortStudentByName();
        testSortStudentByGradeIncreasing();
        testSortStudentByGradeDecreasing();
        testFilterStudentsHighestGrade();
        testFilterStudentsLowestGrade();
    }

    public static void init() {
        String filePath = "D:\\Study\\Java\\with_eclipse\\midterm-oop\\src\\data\\students.csv";
        readListData(filePath);
    }

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7 || dataList.get(0).equals("id")) {
                    continue;
                }

                Student newStudent = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                        .build();

                studentManager.append(newStudent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static void testOriginalData() {
        List<Student> studentList = studentManager.getStudentList();
        studentManager.print(studentList);
    }

    public static void testSortStudentByName() {
        List<Student> sortedList = studentManager.sortStudentByName();
        studentManager.print(sortedList);
    }

    public static void testSortStudentByGradeIncreasing() {
        List<Student> sortedList = studentManager.sortByGrade(true);
        studentManager.print(sortedList);
    }

    public static void testSortStudentByGradeDecreasing() {
        List<Student> sortedList = studentManager.sortByGrade(false);
        studentManager.print(sortedList);
    }

    public static void testFilterStudentsHighestGrade() {
        List<Student> filteredList = studentManager.filterStudentsHighestGrade(5);
        studentManager.print(filteredList);
    }

    public static void testFilterStudentsLowestGrade() {
        List<Student> filteredList = studentManager.filterStudentsLowestGrade(3);
        studentManager.print(filteredList);
    }
}
