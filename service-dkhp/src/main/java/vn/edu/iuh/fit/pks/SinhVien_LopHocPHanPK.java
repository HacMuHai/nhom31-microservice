package vn.edu.iuh.fit.pks;

import java.io.Serializable;
import java.util.Objects;

public class SinhVien_LopHocPHanPK implements Serializable {
    private long sinhVien;
    private long lopHocPhan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVien_LopHocPHanPK that = (SinhVien_LopHocPHanPK) o;
        return sinhVien == that.sinhVien && lopHocPhan == that.lopHocPhan;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sinhVien, lopHocPhan);
    }
}
