package com.example.demoKDL1.KhachHangBuuDien;


import java.sql.Timestamp;

import com.example.demoKDL1.KhachHang.KhachHang;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper=false)
public class KhachHangBuuDien extends KhachHang {
    private String diaChiBuuDien;
    private Timestamp thoiGian;

    public KhachHangBuuDien(){
        // ...
    }

    public KhachHangBuuDien(KhachHang khachHang, String diaChiBuuDien, Timestamp thoiGian){
        this.updateKhachHangButNotId(khachHang);
        this.diaChiBuuDien= diaChiBuuDien;
        this.thoiGian= thoiGian;
    }

    public KhachHangBuuDien(KhachHangBuuDien khbd1){
        this.updateKhachHangButNotId(khbd1);
        this.diaChiBuuDien = khbd1.getDiaChiBuuDien();
        this.thoiGian= khbd1.getThoiGian();
    }

    public void updateKhbdButNotId(KhachHangBuuDien khbd1){
        this.updateKhachHangButNotId(khbd1);
        this.diaChiBuuDien = khbd1.getDiaChiBuuDien();
        this.thoiGian= khbd1.getThoiGian();
    }

}
