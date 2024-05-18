package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "khoa_hocs")
@Builder
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KhoaHoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maKhoaHoc")
    private Long id;
    private String tenKhoaHoc;

    @OneToMany(mappedBy = "khoaHoc",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LopHoc> lopHocs;

    @OneToMany(mappedBy = "khoaHoc",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<ChuongTrinhKhung> chuongTrinhKhungs;

    public KhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }
}
