package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.LoaiHinhDaoTao;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "lop_hocs")
@Builder
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LopHoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLopHoc")
    private long id;
    private String tenLop;
    @Enumerated(EnumType.ORDINAL)
    private LoaiHinhDaoTao loaiHinhDaoTao;

    @ManyToOne
    @JoinColumn(name = "maGV")
    private GiaoVien giaoVien;
    @ManyToOne
    @JoinColumn(name = "maKhocHoc")
    private KhoaHoc khoaHoc;
    @ManyToOne
    @JoinColumn(name = "maNganh")
    private NganhHoc nganhHoc;

    @OneToMany(mappedBy = "lopHoc", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<SinhVien> sinhViens;

    public LopHoc(String tenLop, LoaiHinhDaoTao loaiHinhDaoTao, GiaoVien giaoVien, KhoaHoc khoaHoc, NganhHoc nganhHoc) {
        this.tenLop = tenLop;
        this.loaiHinhDaoTao = loaiHinhDaoTao;
        this.giaoVien = giaoVien;
        this.khoaHoc = khoaHoc;
        this.nganhHoc = nganhHoc;
    }
}
