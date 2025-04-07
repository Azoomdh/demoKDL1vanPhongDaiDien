package com.example.demoKDL1.KhachHangBuuDien;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoKDL1.KhachHang.KhachHang;
import com.example.demoKDL1.KhachHang.KhachHangFakingService;
import com.example.demoKDL1.KhachHang.KhachHangService;
import com.example.demoKDL1.Utils.FakerTool;

@Service
public class KhachHangBuuDienFakingService {

    private static String minKhbdTime= "01:01:2020 00:00:00";
    private static String maxKhbdTime= "01:01:2025 00:00:00";
    
    @Autowired
    KhachHangBuuDienService khbdService1;

    @Autowired
    KhachHangService khService2;

    @Autowired
    KhachHangFakingService khFakingService1;

    public KhachHangBuuDien create1FakeKhbdFromKh(KhachHang khEn1){
        KhachHangBuuDien khbdEn2= new KhachHangBuuDien(khEn1, null,null);

        khbdEn2.setIdKH(khEn1.getIdKH());
        khbdEn2.setDiaChiBuuDien(FakerTool.getAddress());
        khbdEn2.setThoiGian(
            FakerTool.getTimeStampBetween(minKhbdTime, maxKhbdTime)
        );

        return khbdEn2;
    }

    public KhachHangBuuDien create1FakeKhbdFromNull(){
        // KhachHangFakingService khFakingService1= new KhachHangFakingService();
        // KhachHang khEn1= khFakingService1.create1fakeKhachHang();

        KhachHang khEn1= this.khFakingService1.create1fakeKhachHang();

        KhachHangBuuDien khbdEn1= this.create1FakeKhbdFromKh(khEn1);

        return khbdEn1;
    }

    public void createKhbdFromKh(Long soLuong){
        List<KhachHang> listKhachHang1= khService2.getRandomKhachHang(soLuong);
        System.out.println("\n\n\n\n hello khachHangFakingService getRandomKhachHang thanh cong \n\n\n\n");
        List<KhachHangBuuDien> listKhbd2= new ArrayList<KhachHangBuuDien>();

        for(KhachHang kh1 : listKhachHang1){
            listKhbd2
                .add( 
                    this.create1FakeKhbdFromKh(kh1) 
                );
        }

        this.khbdService1.saveAllKhbd(listKhbd2);
    }
    
    public void createKhbdFromNull(Long soLuong){
        List<KhachHangBuuDien> listKhbd1= new ArrayList<KhachHangBuuDien>();

        for(int i=0; i<soLuong; i++){
            listKhbd1
                .add(
                    this.create1FakeKhbdFromNull()
                );
        }
    }
}