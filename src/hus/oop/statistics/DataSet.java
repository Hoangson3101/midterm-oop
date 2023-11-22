package hus.oop.statistics;

public interface DataSet {
    /**
     * Lấy kích thước mẫu.
     * @return kích thước mẫu.
     */
    int size();

    /**
     * Lấy giá trị của phần tử ở vị trí index.
     * @param index
     * @return giá trị phần tử ở vị trí index.
     */
    double get(int index);

    /**
     * Sửa dữ liệu ở vị trí index thành data.
     * @param data
     * @param index
     */
    void set(double data, int index);

    /**
     * Thêm dữ liệu vào cuối tập dữ liệu.
     * @param data
     */
    void append(double data);

    /**
     * Thêm dữ liệu data vào vị trí index của tập dữ liệu.
     * @param data
     * @param index
     */
    void insert(double data, int index);

    /**
     * Xóa phần tử dũ liệu tại vị trí index.
     * @param index
     */
    void remove(int index);

    /**
     * Lấy ra dữ liệu được lưu theo cấu trúc dữ liệu kiểu mảng.
     * @return
     */
    double[] toArray();
}
