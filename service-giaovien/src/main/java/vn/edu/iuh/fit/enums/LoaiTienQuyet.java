package vn.edu.iuh.fit.enums;

public enum LoaiTienQuyet {
    HOCTRUOC(0), TIENQUYET(1), SONGHANH(2);

    private int value;

    LoaiTienQuyet(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LoaiTienQuyet fromValue(int value) {
        for (LoaiTienQuyet trangThai : LoaiTienQuyet.values()) {
            if (trangThai.value == value) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái học tập với giá trị " + value);
    }
}

