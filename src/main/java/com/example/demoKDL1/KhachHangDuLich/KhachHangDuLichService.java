package com.example.demoKDL1.KhachHangDuLich;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhachHangDuLichService {
    @Autowired
    private KhachHangDuLichRepo khdlRepo;

    public Page<KhachHangDuLich> getListKhdl(int sttPage, int sizePage){
        Pageable pageable1= PageRequest.of(sttPage, sizePage);

        return khdlRepo.findAll(pageable1);
    }

    public KhachHangDuLich getKhdlById(Long id){
        Optional<KhachHangDuLich> optKhdlEn1 = this.khdlRepo.findById(id);

        if(optKhdlEn1.isPresent()== false){
            return null;
        }

        return optKhdlEn1.get();
    }

    public KhachHangDuLich createKhdl(KhachHangDuLich khdlEn1){
        KhachHangDuLich khdlEn2= new KhachHangDuLich(khdlEn1);
        
        // khdlEn2.setIdKH(null);
        // vì KHDL kế thừa từ KH, không được setId về null

        khdlEn2 = this.khdlRepo.save(khdlEn2);
        return khdlEn2;
    }

    public KhachHangDuLich updateKhdlById(Long id, KhachHangDuLich khdlEn1){
        Optional<KhachHangDuLich> optKhdlEn2= this.khdlRepo.findById(id);

        if(optKhdlEn2.isPresent()==false){
            return null;
        }

        optKhdlEn2.get().updateKhdlButNotId(khdlEn1);
        
    
        return optKhdlEn2.get();
    }

    public void deleteKhdlById(Long id){
        this.khdlRepo.deleteById(id);
    }

    /*-----------------------------*/
    public void saveAllKhdl(HashSet<KhachHangDuLich> setKhdl1){
        for(KhachHangDuLich khdl : setKhdl1 ){
            khdl.setIdKH(null);
        }
        this.khdlRepo.saveAll(setKhdl1);
    }

    public void saveAllKhdl(List<KhachHangDuLich> listKhdl1){
        for(KhachHangDuLich khdl : listKhdl1){
            khdl.setIdKH(null);
        }
        this.khdlRepo.saveAll(listKhdl1);

        System.out.println("\n\n\n\n KhachHangDuLichService saveAllKhdl thanh cong \n\n\n\n");
    }

}
