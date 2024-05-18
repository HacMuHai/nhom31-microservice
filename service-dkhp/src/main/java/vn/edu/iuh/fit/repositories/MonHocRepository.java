package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.iuh.fit.models.MonHoc;
import vn.edu.iuh.fit.models.MonHoc_CTK;

import java.util.List;

public interface MonHocRepository extends JpaRepository<MonHoc, Long> {

    @Query("select distinct mh_ctk" +
            "    from SinhVien sv\n" +
            "    join LopHoc lh on sv.lopHoc.id = lh.id\n" +
            "    join KhoaHoc kh on lh.khoaHoc.id = kh.id \n" +
            "    join ChuongTrinhKhung ctk on kh.id = ctk.khoaHoc.id\n" +
            "    join MonHoc_CTK mh_ctk on lh.nganhHoc.id = ctk.nganhHoc.id\n" +
            "    join MonHoc mh on mh_ctk.monHoc.id = mh.id\n" +
            "    where  ctk.id = mh_ctk.chuongTrinhKhung.id and\n" +
            "          mh.id not in (select lhp.monHoc.id\n" +
            "                                from SinhVien_LHP svlhp join LopHocPhan lhp on svlhp.lopHocPhan.id = lhp.id\n" +
            "                                where svlhp.sinhVien.id = ?1)")
    List<MonHoc_CTK> findByMssv(long mssv);

}