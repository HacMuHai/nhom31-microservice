package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Table(name = "lop_tin_chis")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LopTinChi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLTC")
    private long id;
    private int soLuongToiDa;
    private int nhom;
    private boolean isLyThuyet;
    private int tietBatDau;
    private int tietKetThuc;
    private String phong;
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "maGV")
    private GiaoVien giaoVien;

    @ManyToOne
    @JoinColumn(name = "maLHP")
    private LopHocPhan lopHocPhan;

    public LopTinChi(int soLuongToiDa, int nhom, boolean isLyThuyet, int tietBatDau, int tietKetThuc, String phong, String ghiChu, GiaoVien giaoVien, LopHocPhan lopHocPhan) {
        this.soLuongToiDa = soLuongToiDa;
        this.nhom = nhom;
        this.isLyThuyet = isLyThuyet;
        this.tietBatDau = tietBatDau;
        this.tietKetThuc = tietKetThuc;
        this.phong = phong;
        this.ghiChu = ghiChu;
        this.giaoVien = giaoVien;
        this.lopHocPhan = lopHocPhan;
    }
}
