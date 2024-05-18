package vn.edu.iuh.fit.enums;

public enum LoaiHinhDaoTao {
    DAITRA(0), CLC(1);

    private int value;

    LoaiHinhDaoTao(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static LoaiHinhDaoTao fromValue(int value) {
        for (LoaiHinhDaoTao trangThai : LoaiHinhDaoTao.values()) {
            if (trangThai.value == value) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái học tập với giá trị " + value);
    }
}
