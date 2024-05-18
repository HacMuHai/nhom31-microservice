package vn.edu.iuh.fit.enums;

public enum TietHoc {
    TIET1_3(0), TIET4_6(1),TIET7_9(2),TIET10_12(3);

    private int value;

    TietHoc(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TietHoc fromValue(int value) {
        for (TietHoc trangThai : TietHoc.values()) {
            if (trangThai.value == value) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái học tập với giá trị " + value);
    }
}
