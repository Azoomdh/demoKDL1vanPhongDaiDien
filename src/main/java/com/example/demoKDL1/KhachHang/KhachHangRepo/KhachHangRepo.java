package com.example.demoKDL1.KhachHang.KhachHangRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demoKDL1.KhachHang.KhachHang;

@Repository
public interface KhachHangRepo 
    extends JpaRepository<KhachHang, Long>
{
    // @Query(value = "SELECT TOP (:soLuong) * FROM khach_hang ORDER BY NEWID()", nativeQuery = true)
    // List<KhachHang> getRandomKhachHang(@Param("soLuong") Long soLuong);
    //     /*
    //         SELECT 
    //             TOP :soLuong 
    //             * 
    //             FROM khach_hang 
    //             ORDER BY NEWID()
    //     */
    // ❌❌❌❌ không rõ lý do gây lỗi 
    // com.microsoft.sqlserver.jdbc.SQLServerException: The column name clazz_ is not valid.       

}
