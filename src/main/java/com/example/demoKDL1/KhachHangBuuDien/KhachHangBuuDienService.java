package com.example.demoKDL1.KhachHangBuuDien;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhachHangBuuDienService {
    @Autowired
    private KhachHangBuuDienRepo khbdRepo;

    public Page<KhachHangBuuDien> getListKhbd(int sttPage, int sizePage){
        Pageable pageable1= PageRequest.of(sttPage, sizePage);

        return khbdRepo.findAll(pageable1);
    }

    public KhachHangBuuDien getKhbdById(Long id){
        Optional<KhachHangBuuDien> optKhbdEn1 = this.khbdRepo.findById(id);

        if(optKhbdEn1.isPresent()== false){
            return null;
        }

        return optKhbdEn1.get();
    }

    public KhachHangBuuDien createKhbd(KhachHangBuuDien khbdEn1){
        KhachHangBuuDien khbdEn2= new KhachHangBuuDien(khbdEn1);
        
        // khbdEn2.setIdKH(null);
        // vì KHBD kế thừa từ KH, không được setId về null

        khbdEn2 = this.khbdRepo.save(khbdEn2);
        return khbdEn2;
    }

    public KhachHangBuuDien updateKhbdById(Long id, KhachHangBuuDien khbdEn1){
        Optional<KhachHangBuuDien> optKhbdEn2= this.khbdRepo.findById(id);

        if(optKhbdEn2.isPresent()==false){
            return null;
        }

        optKhbdEn2.get().updateKhbdButNotId(khbdEn1);
        
    
        return optKhbdEn2.get();
    }

    public void deleteKhdlById(Long id){
        this.khbdRepo.deleteById(id);
    }

    /*-----------------------------*/
    public void saveAllKhbd(HashSet<KhachHangBuuDien> setKhbd1){
        for(KhachHangBuuDien khbd : setKhbd1 ){
            khbd.setIdKH(null);
        }
        this.khbdRepo.saveAll(setKhbd1);
    }

    public void saveAllKhbd(List<KhachHangBuuDien> listKhbd1){
        for(KhachHangBuuDien khbd : listKhbd1){
            khbd.setIdKH(null);
        }
        this.khbdRepo.saveAll(listKhbd1);

        System.out.println("\n\n\n\n KhachHangBuuDienService saveAllKhdl thanh cong \n\n\n\n");
    }

}
