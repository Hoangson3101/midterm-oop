package hus.oop.statistics;

import java.util.Arrays;
import java.util.Random;

public class TestStatistics {
    public static void main(String[] args) {
        /* Yêu cầu:

        I. Hoàn thiện các file source code đã cho. Viết các chức năng test cho chương trình.
        Viết hàm test cho ArrayDataSet:
            1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30]. Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử
               là các số double được sinh ngẫu nhiên, và có số phần tử bằng số tự nhiên đã cho.
            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu. In ra các dữ liệu thống kê về tập dữ liệu
               (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).

         Viết hàm test cho LinkedListDataSet:
            1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30]. Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử
               là các số double được sinh ngẫu nhiên, và có số phần tử bằng số tự nhiên đã cho.
            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu. In ra các dữ liệu thống kê về tập dữ liệu
               (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).

         II. Chạy các hàm test để test chương trình.
         Copy kết quả chạy chương trình và lưu vào file text có tên <TenSinhVien_MaSinhVien_Statistics>.txt
         (ví dụ, NguyenVanA_123456S_Statistics.txt).
         Nén các file source code và file text kết quả chạy chương trình theo định dạng .zip,
         đặt tên là <TenSinhVien_MaSinhVien_Statistics>.zip (ví dụ, NguyenVanA_123456_Statistics.zip) và nộp lên classroom.
         */

        testStatisticsUsingArrayDataSet();
        testStatisticsUsingLinkedListDataSet();
    }

    /**
     * Test function for ArrayDataSet.
     */
    public static void testStatisticsUsingArrayDataSet() {
        Random random = new Random();
        int randomSize = random.nextInt(11) + 20; // Random size between 20 and 30
        ArrayDataSet arrayDataSet = generateRandomArrayDataSet(randomSize);

        BasicStatistics statistics = new BasicStatistics();
        statistics.dataSet = arrayDataSet;
        printStatistics(statistics);

        // Remove elements at the beginning and end
        if (arrayDataSet.size() >= 2) {
            arrayDataSet.remove(0);
            arrayDataSet.remove(arrayDataSet.size() - 1);

            System.out.println("\nAfter removing elements:");
            printStatistics(statistics);
        } else {
            System.out.println("\nCannot remove elements. Dataset size is less than 2.");
        }
    }

    /**
     * Test function for LinkedListDataSet.
     */
    public static void testStatisticsUsingLinkedListDataSet() {
        Random random = new Random();
        int randomSize = random.nextInt(11) + 20; // Random size between 20 and 30
        LinkedListDataSet linkedListDataSet = generateRandomLinkedListDataSet(randomSize);

        BasicStatistics statistics = new BasicStatistics();
        statistics.dataSet = linkedListDataSet;
        printStatistics(statistics);

        // Remove elements at the beginning and end
        if (linkedListDataSet.size() >= 2) {
            linkedListDataSet.remove(0);
            linkedListDataSet.remove(linkedListDataSet.size() - 1);

            System.out.println("\nAfter removing elements:");
            printStatistics(statistics);
        } else {
            System.out.println("\nCannot remove elements. Dataset size is less than 2.");
        }
    }

    /**
     * Generate a random ArrayDataSet with the given size.
     */
    private static ArrayDataSet generateRandomArrayDataSet(int size) {
        ArrayDataSet arrayDataSet = new ArrayDataSet();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arrayDataSet.append(random.nextDouble() * 100); // Random double value between 0 and 100
        }

        return arrayDataSet;
    }

    /**
     * Generate a random LinkedListDataSet with the given size.
     */
    private static LinkedListDataSet generateRandomLinkedListDataSet(int size) {
        LinkedListDataSet linkedListDataSet = new LinkedListDataSet();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            linkedListDataSet.append(random.nextDouble() * 100); // Random double value between 0 and 100
        }

        return linkedListDataSet;
    }

    /**
     * Print statistics for the given dataset.
     */
    private static void printStatistics(Statistics statistics) {
        System.out.println("Dataset: " + Arrays.toString(statistics.rank().toArray()));
        System.out.println("Size: " + statistics.size());
        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());
        System.out.println("Rank: " + Arrays.toString(statistics.rank().toArray()));
        System.out.println("Median: " + statistics.median());
        System.out.println();
    }
}
