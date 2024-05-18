package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "chuong_trinh_khungs")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChuongTrinhKhung implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maCTK")
    private long id;

    @ManyToOne
    @JoinColumn(name = "maNganhHoc")
    private NganhHoc nganhHoc;

    @ManyToOne
    @JoinColumn(name = "maKhoaHoc")
    private KhoaHoc khoaHoc;

    @OneToMany(mappedBy = "chuongTrinhKhung",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<MonHoc_CTK> monHocCtks;


    public ChuongTrinhKhung(NganhHoc nganhHoc, KhoaHoc khoaHoc) {
        this.nganhHoc = nganhHoc;
        this.khoaHoc = khoaHoc;
    }
}
