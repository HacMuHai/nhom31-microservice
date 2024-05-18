package vn.edu.iuh.fit.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import vn.edu.iuh.fit.dto.ThongTinSVResponse;
import vn.edu.iuh.fit.models.SinhVien;
import vn.edu.iuh.fit.repositories.SinhVienRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class SinhVienServices {
    private final SinhVienRepository sinhVienRepository;
    private final WebClient.Builder webClientBuilder;

    public ThongTinSVResponse getThongTin(long id){
        SinhVien sinhVien = sinhVienRepository.findById(id).get();
        return new ThongTinSVResponse(
                sinhVien.getId(),
                sinhVien.getHoTen(),
                sinhVien.getNgaySinh(),
                sinhVien.getUrlImage(),
                sinhVien.getLoaiSinhVien().name(),
                sinhVien.isMale(),
                sinhVien.getLopHoc().getKhoaHoc().getTenKhoaHoc(),
                sinhVien.getLopHoc().getNganhHoc().getKhoa().getTenKhoa(),
                sinhVien.getLopHoc().getId(),
                sinhVien.getLopHoc().getTenLop(),
                sinhVien.getLopHoc().getLoaiHinhDaoTao().name(),
                sinhVien.getLopHoc().getNganhHoc().getId(),
                sinhVien.getLopHoc().getNganhHoc().getTenNganh()
                );
    }

    public ThongTinSVResponse getTest(long id){

        return webClientBuilder.build().get()
                .uri("http://service-sinhvien/dkhp/thongTin"
                        ,uriBuilder -> uriBuilder.queryParam("mssv",id).build())
                .retrieve()
                .bodyToMono(ThongTinSVResponse.class)
                .block();
    }
}
