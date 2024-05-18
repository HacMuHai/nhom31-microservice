package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.pks.MonHocCTKPK;

import java.io.Serializable;
@Entity
@Table(name = "mon_hoc_CTKs")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(MonHocCTKPK.class)
public class MonHoc_CTK implements Serializable {
    @Id
    @JoinColumn(name = "maCTK")
    @ManyToOne
    private ChuongTrinhKhung chuongTrinhKhung;

    @Id
    @JoinColumn(name = "maMonHoc")
    @ManyToOne
    private MonHoc monHoc;

    private int hocKi;
    private boolean isBatBuoc;

}
