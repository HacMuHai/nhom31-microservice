package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.MonHocTienQuyet;
import vn.edu.iuh.fit.pks.MonHocTienQuyetPK;

public interface MonHocTienQuyetRepository extends JpaRepository<MonHocTienQuyet, MonHocTienQuyetPK> {
}