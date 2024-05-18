package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.MonHoc_CTK;
import vn.edu.iuh.fit.pks.MonHocCTKPK;

public interface MonHoc_CTKRepository extends JpaRepository<MonHoc_CTK, MonHocCTKPK> {
}