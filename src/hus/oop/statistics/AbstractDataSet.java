package hus.oop.statistics;

import java.util.Arrays;

public abstract class AbstractDataSet implements DataSet {
    /**
     * Check if the index is within the range [0 - limit].
     * @param index the index to check.
     * @param limit the upper limit of the range.
     * @return true if the index is within the range, false otherwise.
     */
    public boolean checkBoundaries(int index, int limit) {
        return index >= 0 && index <= limit;
    }

    /**
     * Describe the dataset.
     * @return a string representation of the dataset in the format [a1, a2, a3, ..., an].
     */
    @Override
    public String toString() {
        double[] array = toArray();
        return Arrays.toString(array);
    }
}
