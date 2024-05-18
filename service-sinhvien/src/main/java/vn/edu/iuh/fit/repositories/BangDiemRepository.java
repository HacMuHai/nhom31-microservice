package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.BangDiem;
import vn.edu.iuh.fit.pks.SinhVien_LopHocPHanPK;

public interface BangDiemRepository extends JpaRepository<BangDiem, SinhVien_LopHocPHanPK> {
}