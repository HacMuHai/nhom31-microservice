package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.pks.SinhVien_LopHocPHanPK;

import java.io.Serializable;

@Entity
@Table(name = "bang_diems")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SinhVien_LopHocPHanPK.class)
public class BangDiem implements Serializable {
    @Id

    @JoinColumn(name = "mssv")
    @ManyToOne
    private SinhVien sinhVien;

    @Id
    @JoinColumn(name = "maLHP")
    @ManyToOne
    private LopHocPhan lopHocPhan;

    private float diemThuongKy1;
    private float diemThuongKy2;
    private float diemThuongKy3;
    private float diemThucHanh1;
    private float diemThucHanh2;
    private float diemThucHanh3;
    private float diemGK;
    private float diemGKChuyenCan;
    private float diemCuoiKy;
}
