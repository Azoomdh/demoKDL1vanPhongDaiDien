package com.example.demoKDL1.KhachHang;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoKDL1.Utils.FakerTool;
import com.github.javafaker.Faker;

@Service
public class KhachHangFakingService {

    
    @Autowired
    private KhachHangService khachHangService;


    public KhachHang create1fakeKhachHang(){


        /*
         * có 100k bản ghi, 
         * mỗi khách mua 5 lần-> có 20k khách
         * mỗi cửa hàng có 200 khách-> 100 thành phố  
         */
        Long maxIdCity = (long) 200;
        Long minIdCity = (long) 1;

        String minDate= "01:01:2020 00:00:00";
        String maxDate= "01:01:2025 00:00:00";



        String nameKH = FakerTool.getFullname();
        
        Long idCity= FakerTool.getIdBetween(minIdCity, maxIdCity);
        
        Timestamp timeDatHangDauTien = FakerTool.getTimeStampBetween(minDate, maxDate);


        KhachHang khachHangFake1= new KhachHang(nameKH, idCity, timeDatHangDauTien);

        return khachHangFake1;
    }

    public List<KhachHang> createNfakeKhachHang(Long n){
        List<KhachHang> listKh1= new ArrayList<>();

        for(long i=0; i<n; i++){
            listKh1.add(this.create1fakeKhachHang());
        }

        return listKh1;
    }


    /*khachHangRepo.save(List<KhachHang> listKhachHang1); */
    public void createAndSaveNfakeKhachHang(Long n){
        List<KhachHang> listKh1= this.createNfakeKhachHang(n);
        for(KhachHang kh : listKh1){
            kh.setIdKH(null);
        }
        this.khachHangService.createAllKhachHang(listKh1);
    }


    public static void main(String[] args) {
        Faker faker2= new Faker();
        String nameKH = faker2.name().fullName();
        System.out.println(nameKH);
    }

}



