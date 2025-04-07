package com.example.demoKDL1.KhachHangDuLich;


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
public class KhachHangDuLich extends KhachHang {
    private String nameHuongDanVienDuLich;
    private Timestamp thoiGian;

    public KhachHangDuLich(){
        // ...
    }

    public KhachHangDuLich(KhachHang khachHang, String nameHuongDanVienDuLich, Timestamp thoiGian){
        this.updateKhachHangButNotId(khachHang);
        this.nameHuongDanVienDuLich= nameHuongDanVienDuLich;
        this.thoiGian= thoiGian;
    }

    public KhachHangDuLich(KhachHangDuLich khdl1){
        this.updateKhachHangButNotId(khdl1);
        this.nameHuongDanVienDuLich = khdl1.getNameHuongDanVienDuLich();
        this.thoiGian= khdl1.getThoiGian();
    }

    public void updateKhdlButNotId(KhachHangDuLich khdl1){
        this.updateKhachHangButNotId(khdl1);
        this.nameHuongDanVienDuLich = khdl1.getNameHuongDanVienDuLich();
        this.thoiGian= khdl1.getThoiGian();
    }

}
