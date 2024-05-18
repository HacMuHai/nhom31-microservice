package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.iuh.fit.enums.TrangThaiSvLHP;
import vn.edu.iuh.fit.pks.SinhVien_LopHocPHanPK;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "sinhvien_lophocphans")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SinhVien_LopHocPHanPK.class)
public class SinhVien_LHP implements Serializable {
    @Id
    @JoinColumn(name = "mssv")
    @ManyToOne
    private SinhVien sinhVien;

    @Id
    @JoinColumn(name = "maLHP")
    @ManyToOne
    private LopHocPhan lopHocPhan;

    private TrangThaiSvLHP trangThaiSvLHP;
    private boolean isChinh;
    private int nhomTH;
    private boolean isDaNopHP;
    private LocalDate ngayNopHP;
    private LocalDate ngayDKLop;

}
