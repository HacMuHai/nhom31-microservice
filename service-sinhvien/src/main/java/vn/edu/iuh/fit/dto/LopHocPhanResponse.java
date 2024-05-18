package vn.edu.iuh.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LopHocPhanResponse {
    private long maLHP;
    private String tenMonHoc;
    private String tenLopDuKien;
    private int soTC;
    private int nhom;
    private double hocPhi;
    private LocalDate hanNop;
//    private String trangThaiDK; (dk mơi || hoc lai)
    private LocalDate ngayDangKy;
    private String trangThaiLHP;
}
