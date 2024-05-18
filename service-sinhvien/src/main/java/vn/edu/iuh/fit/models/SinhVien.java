package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.LoaiSinhVien;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sinh_viens")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mssv")
    private long id;
    private String hoTen;
    private LocalDate ngaySinh;
    private String urlImage;
    private LoaiSinhVien loaiSinhVien;
    private boolean isMale;

    @ManyToOne
    @JoinColumn(name = "maLopHoc")
    private LopHoc lopHoc;

    @OneToMany(mappedBy = "sinhVien", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<SinhVien_LHP> sinhVien_lhps;

    public SinhVien(String hoTen, LocalDate ngaySinh, String urlImage, LoaiSinhVien loaiSinhVien, boolean isMale, LopHoc lopHoc) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.urlImage = urlImage;
        this.loaiSinhVien = loaiSinhVien;
        this.isMale = isMale;
        this.lopHoc = lopHoc;
    }
}
