package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "giao_viens")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GiaoVien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maGV")
    private long id;
    private String hoTen;
    private LocalDate ngaySinh;

    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;

    @OneToMany(mappedBy = "giaoVien",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LopHoc> lopHocs;

    @OneToMany(mappedBy = "giaoVien",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LopTinChi> lopTinChis;

    public GiaoVien(String hoTen, LocalDate ngaySinh, Khoa khoa) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return "GiaoVien{" +
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", khoa=" + khoa +
                '}';
    }
}
