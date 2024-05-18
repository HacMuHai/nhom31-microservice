package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "nganh_hocs")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NganhHoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maNganh")
    private Long id;
    private String tenNganh;

    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;

    @OneToMany(mappedBy = "nganhHoc",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<ChuongTrinhKhung> chuongTrinhKhungs;

    @OneToMany(mappedBy = "nganhHoc",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<LopHoc> lopHocs;
}
