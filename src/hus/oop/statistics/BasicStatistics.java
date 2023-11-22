package hus.oop.statistics;

import java.util.Arrays;

public class BasicStatistics implements Statistics {
    public DataSet dataSet;

    /**
     * Constructor to initialize the dataset.
     */
    public BasicStatistics() {
        // Initialize an empty dataset
        this.dataSet = new ArrayDataSet();
    }

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        return dataSet.size();
    }

    @Override
    public double max() {
        if (size() == 0) {
            throw new IllegalStateException("Dataset is empty");
        }

        double max = dataSet.get(0);
        for (int i = 1; i < size(); i++) {
            double current = dataSet.get(i);
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    @Override
    public double min() {
        if (size() == 0) {
            throw new IllegalStateException("Dataset is empty");
        }

        double min = dataSet.get(0);
        for (int i = 1; i < size(); i++) {
            double current = dataSet.get(i);
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    @Override
    public double mean() {
        if (size() == 0) {
            throw new IllegalStateException("Dataset is empty");
        }

        double sum = 0;
        for (int i = 0; i < size(); i++) {
            sum += dataSet.get(i);
        }
        return sum / size();
    }

    @Override
    public double variance() {
        if (size() == 0) {
            throw new IllegalStateException("Dataset is empty");
        }

        double mean = mean();
        double sumSquaredDifferences = 0;

        for (int i = 0; i < size(); i++) {
            double difference = dataSet.get(i) - mean;
            sumSquaredDifferences += difference * difference;
        }

        return sumSquaredDifferences / size();
    }

    @Override
    public AbstractDataSet rank() {
        if (size() == 0) {
            throw new IllegalStateException("Dataset is empty");
        }

        // Create a copy of the original dataset
        double[] originalData = Arrays.copyOf(dataSet.toArray(), size());

        // Sort the copy to get the rank
        Arrays.sort(originalData);

        // Create a new ArrayDataSet using the sorted data
        ArrayDataSet rankedDataSet = new ArrayDataSet();
        for (double value : originalData) {
            rankedDataSet.append(value);
        }

        return rankedDataSet;
    }

    @Override
    public double median() {
        if (size() == 0) {
            throw new IllegalStateException("Dataset is empty");
        }

        double[] sortedData = Arrays.copyOf(dataSet.toArray(), size());
        Arrays.sort(sortedData);

        if (size() % 2 == 0) {
            // If the size is even, take the average of the middle two values
            int middleIndex1 = size() / 2 - 1;
            int middleIndex2 = size() / 2;
            return (sortedData[middleIndex1] + sortedData[middleIndex2]) / 2.0;
        } else {
            // If the size is odd, return the middle value
            int middleIndex = size() / 2;
            return sortedData[middleIndex];
        }
    }
}
