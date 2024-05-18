package vn.edu.iuh.fit.enums;

public enum LoaiSinhVien {
    THOIHOC(-1), DANGHOC(0), DATOTNGHIEP(1);

    private int value;

    LoaiSinhVien(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LoaiSinhVien fromValue(int value) {
        for (LoaiSinhVien trangThai : LoaiSinhVien.values()) {
            if (trangThai.value == value) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái học tập với giá trị " + value);
    }
}
