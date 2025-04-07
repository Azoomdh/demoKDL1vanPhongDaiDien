package com.example.demoKDL1.KhachHang;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demoKDL1.KhachHang.KhachHangRepo.KhachHangRepo;
import com.example.demoKDL1.KhachHang.KhachHangRepo.KhachHangRepoCustom;

@Service
public class KhachHangService {
    
    @Autowired
    private KhachHangRepo khachHangRepo;

    @Autowired
    private KhachHangRepoCustom khachHangRepoCustom;

    public Page<KhachHang> getListKhachHang(int sttPage, int sizePage){

        Pageable pageable1 = PageRequest.of(sttPage, sizePage);

        return khachHangRepo.findAll(pageable1);
    }

    public KhachHang getKhachHangById(Long id){
        Optional<KhachHang> optKhachHangEn1= this.khachHangRepo.findById(id);

        if(optKhachHangEn1.isPresent()== false){
            return null;
        }

        return optKhachHangEn1.get();
    }

    public KhachHang createKhachHang(KhachHang khachHangEn1){
        KhachHang khachHangEn2 = new KhachHang(khachHangEn1);
        khachHangEn2.setIdKH(null);
        khachHangEn2 = this.khachHangRepo.save(khachHangEn2);
        return khachHangEn2;
    }

    public void createAllKhachHang(List<KhachHang> listKhachHang){
        for(KhachHang kh : listKhachHang){
            kh.setIdKH(null);
        }
        this.khachHangRepo.saveAll(listKhachHang);
    }
    
    public KhachHang updateKhachHangById(Long id, KhachHang KhachHangEn1){
        Optional<KhachHang> optKhachHangEn2 = this.khachHangRepo.findById(id);

        if(optKhachHangEn2.isPresent()== false){
            return null;
        }

        optKhachHangEn2.get().updateKhachHangButNotId(KhachHangEn1);

        return optKhachHangEn2.get();
    }

    public void deleteKhachHangById(Long id){
        this.khachHangRepo.deleteById(id);
    }

    /*-------------------------------------------------- */
    
    public List<KhachHang> getRandomKhachHang(Long soLuong){
        return this.khachHangRepoCustom.getRandomKhachHang(soLuong);
    }

}
