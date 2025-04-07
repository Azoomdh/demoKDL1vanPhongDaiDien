package com.example.demoKDL1.KhachHangDuLich;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoKDL1.KhachHang.KhachHang;
import com.example.demoKDL1.KhachHang.KhachHangFakingService;
import com.example.demoKDL1.KhachHang.KhachHangService;
import com.example.demoKDL1.Utils.FakerTool;

@Service
public class KhachHangDuLichFakingService {

    private static String minKhdlTime= "01:01:2020 00:00:00";
    private static String maxKhdlTime= "01:01:2025 00:00:00";
    
    @Autowired
    KhachHangDuLichService khdlService1;

    @Autowired
    KhachHangService khService2;

    @Autowired
    KhachHangFakingService khFakingService1;

    public KhachHangDuLich create1FakeKhdlFromKh(KhachHang khEn1){
        KhachHangDuLich khdlEn2= new KhachHangDuLich(khEn1, null,null);

        khdlEn2.setIdKH(khEn1.getIdKH());
        khdlEn2.setNameHuongDanVienDuLich(FakerTool.getFullname());
        khdlEn2.setThoiGian(
            FakerTool.getTimeStampBetween(minKhdlTime, maxKhdlTime)
        );

        return khdlEn2;
    }

    public KhachHangDuLich create1FakeKhdlFromNull(){
        // KhachHangFakingService khFakingService1= new KhachHangFakingService();
        // KhachHang khEn1= khFakingService1.create1fakeKhachHang();

        KhachHang khEn1= this.khFakingService1.create1fakeKhachHang();

        KhachHangDuLich khdlEn1= this.create1FakeKhdlFromKh(khEn1);

        return khdlEn1;
    }

    public void createKhdlFromKh(Long soLuong){
        List<KhachHang> listKhachHang1= khService2.getRandomKhachHang(soLuong);
        System.out.println("\n\n\n\n hello khachHangFakingService getRandomKhachHang thanh cong \n\n\n\n");
        List<KhachHangDuLich> listKhdl2= new ArrayList<KhachHangDuLich>();

        for(KhachHang kh1 : listKhachHang1){
            listKhdl2
                .add( 
                    this.create1FakeKhdlFromKh(kh1) 
                );
        }

        this.khdlService1.saveAllKhdl(listKhdl2);
    }
    
    public void createKhdlFromNull(Long soLuong){
        List<KhachHangDuLich> listKhdl1= new ArrayList<KhachHangDuLich>();

        for(int i=0; i<soLuong; i++){
            listKhdl1
                .add(
                    this.create1FakeKhdlFromNull()
                );
        }
    }
}