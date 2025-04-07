package com.example.demoKDL1.KhachHang.KhachHangRepo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demoKDL1.KhachHang.KhachHang;

public class KhachHangSqlRowMapper 
    implements RowMapper<KhachHang>
{
    @Override
    public KhachHang mapRow(ResultSet hangTraVe, int sttHang){
        try {
            KhachHang khachHang1= new KhachHang();

            khachHang1.setIdKH(hangTraVe.getLong("idkh"));
            khachHang1.setIdCity(hangTraVe.getLong("id_city"));
            khachHang1.setNameKH(hangTraVe.getString("namekh"));
            khachHang1.setTimeDatHangDauTien(hangTraVe.getTimestamp("time_dat_hang_dau_tien"));

            return khachHang1;
        }
        
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
