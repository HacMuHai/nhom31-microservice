package vn.edu.iuh.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HocPhanResponse {
    private long maHocPhan;
    private String tenMon;
    private int soTC;
    private boolean isBatBuoc;
    private List<Long> hocPhanTienQuyents;
}
