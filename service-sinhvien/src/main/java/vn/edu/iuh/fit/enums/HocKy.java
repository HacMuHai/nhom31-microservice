package vn.edu.iuh.fit.enums;

public enum HocKy {
    KYHE(0),KY1(1), KY2(2);

    private int value;

    HocKy(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static HocKy fromValue(int value) {
        for (HocKy trangThai : HocKy.values()) {
            if (trangThai.value == value) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái học tập với giá trị " + value);
    }
}
