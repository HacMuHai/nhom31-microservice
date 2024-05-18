package vn.edu.iuh.fit.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.dto.HocPhanResponse;
import vn.edu.iuh.fit.models.MonHoc_CTK;
import vn.edu.iuh.fit.repositories.MonHocRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MonHocService {
    private final MonHocRepository monHocRepository;

    public List<HocPhanResponse> getHPChoDK(long mssv) {
        List<MonHoc_CTK> monHocCtks = monHocRepository.findByMssv(mssv);
        return monHocCtks.stream().map(this::mapToHocPhanResponse).toList();
    }

    private HocPhanResponse mapToHocPhanResponse(MonHoc_CTK monHocCtk){
        return new HocPhanResponse(
                monHocCtk.getMonHoc().getId(),
                monHocCtk.getMonHoc().getTenMon(),
                monHocCtk.getMonHoc().getSoChiLT()+ monHocCtk.getMonHoc().getSoChiTH(),
                monHocCtk.isBatBuoc(),
                monHocCtk.getMonHoc().getMonHocTienQuyets().stream().map(x->x.getMonHocTienQuyet().getId()).toList());
    }
}
