package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.LoaiTienQuyet;
import vn.edu.iuh.fit.pks.MonHocTienQuyetPK;

import java.io.Serializable;

@Entity
@Table(name = "mon_hoc_tien_quyets")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(MonHocTienQuyetPK.class)
public class MonHocTienQuyet implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "maMonHoc")
    private MonHoc monHoc;

    @Id
    @ManyToOne
    @JoinColumn(name = "maMonTienQuyet")
    private MonHoc monHocTienQuyet;

    @Enumerated(EnumType.ORDINAL)
    private LoaiTienQuyet loaiTienQuyet;
}
