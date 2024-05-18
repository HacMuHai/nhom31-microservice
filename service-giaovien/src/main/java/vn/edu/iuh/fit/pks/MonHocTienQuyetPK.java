package vn.edu.iuh.fit.pks;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter @Setter
public class MonHocTienQuyetPK implements Serializable {
    private long monHoc;
    private long monHocTienQuyet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonHocTienQuyetPK that = (MonHocTienQuyetPK) o;
        return monHoc == that.monHoc && monHocTienQuyet == that.monHocTienQuyet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(monHoc, monHocTienQuyet);
    }
}
