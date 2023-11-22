package hus.oop.studentmanager;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList;

    StudentManager() {
        this.studentList = new LinkedList<>();
    }

    private boolean checkBoundaries(int index, int limit) {
        return index >= 0 && index <= limit;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void append(Student student) {
        studentList.add(student);
    }

    public void add(Student student, int index) {
        if (checkBoundaries(index, studentList.size())) {
            studentList.add(index, student);
        }
    }

    public void remove(int index) {
        if (checkBoundaries(index, studentList.size() - 1)) {
            studentList.remove(index);
        }
    }

    public Student studentAt(int index) {
        if (checkBoundaries(index, studentList.size() - 1)) {
            return studentList.get(index);
        }
        return null; // or throw an exception, depending on your requirements
    }

    public List<Student> sortStudentByName() {
        List<Student> sortedList = new LinkedList<>(studentList);
        sortedList.sort((student1, student2) ->
                Comparator.comparing(Student::getLastname)
                        .thenComparing(Student::getFirstname)
                        .compare(student1, student2)
        );
        return sortedList;
    }

    public List<Student> sortByGrade(boolean increasingOrder) {
        List<Student> sortedList = new LinkedList<>(studentList);
        Collections.sort(sortedList, new MyStudentComparator(increasingOrder));
        return sortedList;
    }

    public List<Student> filterStudentsHighestGrade(int howMany) {
        List<Student> sortedList = sortByGrade(true);
        return sortedList.subList(0, Math.min(howMany, sortedList.size()));
    }

    public List<Student> filterStudentsLowestGrade(int howMany) {
        List<Student> sortedList = sortByGrade(false);
        return sortedList.subList(0, Math.min(howMany, sortedList.size()));
    }

    private static class MyStudentComparator implements Comparator<Student> {
        private final boolean increasingOrder;

        public MyStudentComparator(boolean increasingOrder) {
            this.increasingOrder = increasingOrder;
        }

        @Override
        public int compare(Student left, Student right) {
            int comparison = Double.compare(left.getAverageGrade(), right.getAverageGrade());
            return increasingOrder ? comparison : -comparison;
        }
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student student : studentList) {
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
