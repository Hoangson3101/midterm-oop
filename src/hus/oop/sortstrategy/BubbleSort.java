package hus.oop.sortstrategy;

public class BubbleSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Bubble sort.
     * @param data
     */
    @Override
    public void sort(double[] data, boolean order) {
        if (order) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự tăng dần,
     * sử dụng thuật toán Bubble sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        int n = data.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (data[i - 1] > data[i]) {
                    // Swap elements
                    double temp = data[i - 1];
                    data[i - 1] = data[i];
                    data[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Bubble sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        int n = data.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (data[i - 1] < data[i]) {
                    // Swap elements
                    double temp = data[i - 1];
                    data[i - 1] = data[i];
                    data[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
