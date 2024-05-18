package vn.edu.iuh.fit.enums;

public enum TrangThaiSvLHP {
    DANGHOC(0),QUAMON(1), NOMON(-1);

    private int value;

    TrangThaiSvLHP(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TrangThaiSvLHP fromValue(int value) {
        for (TrangThaiSvLHP trangThai : TrangThaiSvLHP.values()) {
            if (trangThai.value == value) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái học tập với giá trị " + value);
    }
}
