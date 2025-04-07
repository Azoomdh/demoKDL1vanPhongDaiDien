package com.example.demoKDL1.KhachHang;

import java.sql.Timestamp;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class KhachHang {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKH;
    
    private String nameKH;
    private Long idCity;
    private Timestamp timeDatHangDauTien;

    public KhachHang(){
        // ...
    }


    public KhachHang(String nameKH, Long idCity, Timestamp timeDatHangDauTien) {
        this.nameKH = nameKH;
        this.idCity = idCity;
        this.timeDatHangDauTien = timeDatHangDauTien;
    }


    public KhachHang(KhachHang khachHang1){
        this.nameKH= khachHang1.getNameKH();
        this.idCity= khachHang1.getIdCity();
        this.timeDatHangDauTien= khachHang1.getTimeDatHangDauTien();
    }

    public void updateKhachHangButNotId(KhachHang khachHang1){
        this.nameKH= khachHang1.getNameKH();
        this.idCity= khachHang1.getIdCity();
        this.timeDatHangDauTien= khachHang1.getTimeDatHangDauTien();
    }

}
