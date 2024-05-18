package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.enums.*;
import vn.edu.iuh.fit.models.*;
import vn.edu.iuh.fit.repositories.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ServiceSinhvienApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSinhvienApplication.class, args);
    }

}

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private KhoaRepository khoaRepository;
    @Autowired
    private NganhHocRepository nganhHocRepository;
    @Autowired
    private GiaoVienRepository giaoVienRepository;
    @Autowired
    private KhoaHocRepository khoaHocRepository;
    @Autowired
    private ChuongTrinhKhungRepository chuongTrinhKhungRepository;


    //    @Bean
    CommandLineRunner initData(LopHocRepository lopHocRepository, SinhVienRepository sinhVienRepository, MonHocRepository monHocRepository, MonHoc_CTKRepository monHoc_CTKRepository, MonHocTienQuyetRepository monHocTienQuyetRepository, LopHocPhanRepository lopHocPhanRepository, LopTinChiRepository lopTinChiRepository, SinhVien_LHPRepository sinhVien_LHPRepository) {
        return args -> {
            Random rnd = new Random();

            //add Khoa
            Khoa khoaCNTT = new Khoa("Cong nghe thong tin");
            Khoa khoaKT = new Khoa("Tai chinh");
            khoaRepository.save(khoaCNTT);
            khoaRepository.save(khoaKT);

            //add Nganh
            NganhHoc nganhCNTT = new NganhHoc();
            for (int i = 1; i <= 4; i++) {
                nganhCNTT = NganhHoc.builder().tenNganh("Nganh CNTT#" + i).khoa(khoaCNTT).build();
                nganhHocRepository.save(nganhCNTT);
            }
            for (int i = 1; i <= 4; i++) {
                NganhHoc nganhHoc = NganhHoc.builder().tenNganh("Nganh KT#" + i).khoa(khoaKT).build();
                nganhHocRepository.save(nganhHoc);
            }

            //add Nganh
            GiaoVien giaoVienCNTT = new GiaoVien();
            for (int i = 1; i <= 4; i++) {
                giaoVienCNTT = new GiaoVien("GV CNTT#" + i, LocalDate.of(1990, i, i), khoaCNTT);
                giaoVienRepository.save(giaoVienCNTT);
            }
            for (int i = 1; i <= 4; i++) {
                GiaoVien giaoVien = new GiaoVien("GV KT#" + i, LocalDate.of(1990, i, i), khoaKT);
                giaoVienRepository.save(giaoVien);
            }

            //add Khoa hoc
            for (int i = 1; i <= 2; i++) {
                KhoaHoc khoaHoc = new KhoaHoc("K" + (16 + i));
                khoaHocRepository.save(khoaHoc);
            }

            //add Chuong Trinh Khung
            ChuongTrinhKhung chuongTrinhKhungCNTT = new ChuongTrinhKhung();
            for (long i = 1; i <= 2; i++) {
                chuongTrinhKhungCNTT = new ChuongTrinhKhung(nganhCNTT, KhoaHoc.builder().id(i).build());
                chuongTrinhKhungRepository.save(chuongTrinhKhungCNTT);
            }

            //add Lop hoc
            LopHoc lopHoc = new LopHoc();
            for (int i = 1; i <= 4; i++) {
                lopHoc = new LopHoc("Lop CNTT#" + i, LoaiHinhDaoTao.fromValue(i % 2), giaoVienCNTT, KhoaHoc.builder().id(2L).build(), nganhCNTT);
                lopHocRepository.save(lopHoc);
            }

            //add Sinh vien
            SinhVien sinhVien = new SinhVien();
            for (int i = 1; i <= 30; i++) {
                sinhVien = new SinhVien("SV CNTT#" + i, LocalDate.of(2003, 1, (int) i % 31), "https://plus.unsplash.com/premium_photo-1661758351472-52ed02e99496?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8SVR8ZW58MHx8MHx8fDA%3D", LoaiSinhVien.DANGHOC, rnd.nextBoolean(), lopHoc);
                sinhVienRepository.save(sinhVien);
            }

            //add Mon hoc
            //add Mon Hoc - Chuong Trinh Khung
            MonHoc monHoc = new MonHoc();
            MonHoc_CTK monHocCtk = new MonHoc_CTK();

            for (int i = 1; i <= 30; i++) {
                monHoc = new MonHoc("Mon CNTT#" + i, rnd.nextInt(2, 4), rnd.nextInt(0, 2), khoaCNTT);
                monHocRepository.save(monHoc);

                monHocCtk = new MonHoc_CTK(chuongTrinhKhungCNTT, monHoc, rnd.nextInt(1, 9), rnd.nextBoolean());
                monHoc_CTKRepository.save(monHocCtk);

            }

            //add Mon Hoc - Chuong Trinh Khung
            for (int i = 26; i <= 30; i++) {
                MonHocTienQuyet monHocTienQuyet = new MonHocTienQuyet(MonHoc.builder().id((long) i).build(), MonHoc.builder().id((long) i - 10 + rnd.nextLong(1, 4)).build(), LoaiTienQuyet.HOCTRUOC);
                monHocTienQuyetRepository.save(monHocTienQuyet);
            }

            //add Lop hoc phan
            LopHocPhan lopHocPhan = new LopHocPhan();
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    lopHocPhan = new LopHocPhan("LopHocPhan #" + j + "" + i, 2023, HocKy.KY1, TrangThaiLHP.CHODANGKY, 2500000, LocalDate.of(2023, 11, 1), MonHoc.builder().id(j).build());
                    lopHocPhanRepository.save(lopHocPhan);
                }
            }

            //add Lop Tin Chi
            LopTinChi lopTinChi = new LopTinChi();
            int[] tiet = {1, 4, 7, 10};
            for (int i = 1; i <= 3; i++) {
                lopTinChi = new LopTinChi(30, 0, true, tiet[i], tiet[i] + 2, "A1.0" + i, "", GiaoVien.builder().id(i).build(), LopHocPhan.builder().id(i).build());
                lopTinChiRepository.save(lopTinChi);
            }

            //add Sinh Vien-Lop Hoc Phan
            SinhVien_LHP sinhVienLhp = new SinhVien_LHP();
            for (int j = 1; j <= 3; j++) {
                for (int i = 1; i <= 30; i++) {
                    sinhVienLhp = new SinhVien_LHP(SinhVien.builder().id(i).build(), LopHocPhan.builder().id(j).build(), TrangThaiSvLHP.DANGHOC, true, 0, true, LocalDate.of(2023, 10, 10), LocalDate.of(2023, 9, 1));
                    sinhVien_LHPRepository.save(sinhVienLhp);
                }
            }

        };
    }

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}
