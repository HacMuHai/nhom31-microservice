package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.enums.HocKy;
import vn.edu.iuh.fit.models.SinhVien_LHP;
import vn.edu.iuh.fit.pks.SinhVien_LopHocPHanPK;

import java.util.List;

public interface SinhVien_LHPRepository extends JpaRepository<SinhVien_LHP, SinhVien_LopHocPHanPK> {
    @Query("""
            select s from SinhVien_LHP s
            where s.sinhVien.id = ?1 and s.lopHocPhan.namHoc = ?2 and s.lopHocPhan.hocKy = ?3""")
    List<SinhVien_LHP> findBySinhVien_IdAndLopHocPhan_NamHocAndLopHocPhan_HocKy(long id, int namHoc, HocKy hocKy);
}