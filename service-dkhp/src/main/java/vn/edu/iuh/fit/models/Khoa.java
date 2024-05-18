package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "khoas")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Khoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maKhoa")
    private long id;
    private String tenKhoa;

    public Khoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    @OneToMany(mappedBy = "khoa",fetch = FetchType.LAZY)
    private List<GiaoVien> giaoViens;

    @OneToMany(mappedBy = "khoa",fetch = FetchType.LAZY)
    private List<NganhHoc> nganhHocs;

    @OneToMany(mappedBy = "khoa",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<MonHoc> monHocs;


    @Override
    public String toString() {
        return "Khoa{" +
                "id=" + id +
                ", tenKhoa='" + tenKhoa + '\'' +
//                ", giaoViens=" + giaoViens +
                '}';
    }
}
