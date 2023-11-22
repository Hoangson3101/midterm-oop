package hus.oop.sortstrategy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class TestSortStrategy {
    public static void main(String[] args) {
        // Generate a random natural number in the range [20 - 30].
        int randomSize = new Random().nextInt(11) + 20;

        // Generate a random array of doubles with the size generated above.
        double[] data = new double[randomSize];
        for (int i = 0; i < randomSize; i++) {
            data[i] = Math.random() * 100; // Adjust the range if needed
        }

        // Create two more arrays by copying the data array.
        double[] dataCopy1 = Arrays.copyOf(data, data.length);
        double[] dataCopy2 = Arrays.copyOf(data, data.length);

        // Create a SortStrategy object.
        SortStrategy sorter = SortStrategy.getInstance();

        // Test Bubble Sort
        testSortingAlgorithm(sorter, new BubbleSort(), data, "Bubble Sort");

        // Test Insertion Sort
        testSortingAlgorithm(sorter, new InsertionSort(), dataCopy1, "Insertion Sort");

        // Test Selection Sort
        testSortingAlgorithm(sorter, new SelectionSort(), dataCopy2, "Selection Sort");

        // Save the results to a text file
        saveResultsToFile(data, dataCopy1, dataCopy2);
    }

    private static void testSortingAlgorithm(SortStrategy sorter, Sorter algorithm, double[] data, String algorithmName) {
        sorter.setSortee(algorithm);
        System.out.println("Using " + algorithmName + " Algorithm:");
        System.out.println("Before sorting: " + Arrays.toString(data));
        sorter.sort(data);
        System.out.println("After sorting: " + Arrays.toString(data));
        System.out.println();
    }

    private static void saveResultsToFile(double[] data1, double[] data2, double[] data3) {
        try (FileWriter writer = new FileWriter("results.txt")) {
            writer.write("Original Data: " + Arrays.toString(data1) + "\n\n");
            writer.write("Data after Insertion Sort: " + Arrays.toString(data2) + "\n\n");
            writer.write("Data after Selection Sort: " + Arrays.toString(data3) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
