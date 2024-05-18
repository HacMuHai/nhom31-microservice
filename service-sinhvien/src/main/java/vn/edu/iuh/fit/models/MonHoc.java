package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mon_hocs")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MonHoc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maMonHoc")
    private long id;
    private String tenMon;
    private int soChiLT;
    private int soChiTH;

    @ManyToOne
    @JoinColumn(name = "maKhoa")
    private Khoa khoa;

    @OneToMany(mappedBy = "monHoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MonHoc_CTK> monHocCtks;

    @OneToMany(mappedBy = "monHoc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MonHocTienQuyet> monHocTienQuyets;

    public MonHoc(String tenMon, int soChiLT, int soChiTH, Khoa khoa) {
        this.tenMon = tenMon;
        this.soChiLT = soChiLT;
        this.soChiTH = soChiTH;
        this.khoa = khoa;
    }


    public int getSoTC() {
        return soChiLT + soChiTH;
    }
}
