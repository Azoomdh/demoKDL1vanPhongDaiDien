package com.example.demoKDL1.KhachHang.KhachHangRepo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demoKDL1.KhachHang.KhachHang;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class KhachHangRepoCustom {

    // ❌ kết luận= dùng JPA là bị lỗi
    // @Autowired
    // private EntityManager entityManager1;

    // @Transactional
    // public List<KhachHang> getRandomKhachHang(Long soLuong){
    //     String lenhSql1= "SELECT TOP (:soLuong)  [idkh] ,[id_city],[namekh],[time_dat_hang_dau_tien] FROM khach_hang ORDER BY NEWID()";
    //     Query query1= entityManager1.createNativeQuery(lenhSql1, KhachHang.class);
    //     query1.setParameter("soLuong", soLuong);
    //     List<Object[]> ketquaQuery1= query1.getResultList();
    //     List<KhachHang> listKhachHang1= new ArrayList<>();
    //     for(Object[] motHang : ketquaQuery1){
    //         KhachHang khachHangA= new KhachHang();
    //         khachHangA.setIdKH( (Long)motHang[0] );
    //         khachHangA.setIdCity( (Long)motHang[1] );
    //         khachHangA.setNameKH( (String)motHang[2] );
    //         khachHangA.setTimeDatHangDauTien( (Timestamp)motHang[3] );
    //         listKhachHang1.add(khachHangA);
    //     }
    //     System.out.println("\n\n\n\n hello khachHangRepoCustom Thanh Cong \n\n\n\n");
    //     return listKhachHang1;
    // }
    // ❌❌❌❌❌❌  vẫn bị lỗi clazz__

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public List<KhachHang> getRandomKhachHang(Long soLuong){
        String lenhSql1 = "SELECT TOP ("+ soLuong+ ")  [idkh] ,[id_city],[namekh],[time_dat_hang_dau_tien] FROM khach_hang ORDER BY NEWID()";
        return 
            jdbcTemplate
                .query(
                    lenhSql1,
                    new KhachHangSqlRowMapper()
                )
            ;
    }
}

