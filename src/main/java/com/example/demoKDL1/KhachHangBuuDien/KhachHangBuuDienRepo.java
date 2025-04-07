package com.example.demoKDL1.KhachHangBuuDien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangBuuDienRepo 
    extends JpaRepository<KhachHangBuuDien, Long>
{

}
