package vn.edu.iuh.fit.enums;

public enum TrangThaiLHP {
    CHODANGKY(-1), DANGHOC(0),DAKETTHUC(1);

    private int value;

    TrangThaiLHP(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TrangThaiLHP fromValue(int value) {
        for (TrangThaiLHP trangThai : TrangThaiLHP.values()) {
            if (trangThai.value == value) {
                return trangThai;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy trạng thái học tập với giá trị " + value);
    }
}
