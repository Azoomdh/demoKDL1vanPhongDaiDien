package com.example.demoKDL1.KhachHangDuLich;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangDuLichRepo 
    extends JpaRepository<KhachHangDuLich, Long>
{

}
