package hus.oop.statistics;

public interface Statistics {
    /**
     * Lấy kích thước mẫu.
     * @return kích thước mẫu (số phần tử trong mẫu).
     */
    int size();

    /**
     * Lấy giá trị của phần tử lớn nhất trong mẫu.
     * @return giá trị của phần tử lớn nhất trong mẫu.
     */
    double max();

    /**
     * Lấy giá trị của phần tử nhỏ nhất trong mẫu.
     * @return giá trị của phần tử nhỏ nhất trong mẫu.
     */
    double min();

    /**
     * Tính kỳ vọng mẫu.
     * @return kỳ vọng mẫu.
     */
    double mean();

    /**
     * Tính phương sai mẫu.
     * @return phương sai mẫu.
     */
    double variance();

    /**
     * Tính các giá trị rank mẫu.
     * @return rank mẫu.
     */
    AbstractDataSet rank();

    /**
     * Tìm giá trị median mẫu.
     * @return median mẫu.
     */
    double median();
}
