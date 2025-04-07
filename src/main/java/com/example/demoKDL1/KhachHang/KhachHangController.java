package com.example.demoKDL1.KhachHang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KhachHangController {

    @Autowired
    KhachHangService khService1;

    @Autowired
    KhachHangFakingService khFakingService1;
    
    @GetMapping(value = {"/khachHang/homeView", "/khachHang"})
    public String getKHhomeView(Model model){
        return "KhachHang/HomeView";
    }

    @GetMapping("/khachHang/generateFakeKhachHangView")
    public String getGenerateFakeKhachHangView(Model model){
        return "KhachHang/GenerateFakeKhachHangView";
    }

    @PostMapping("/khachHang/generateFakeKhachHangView/sendForm")
    public String postAtGenerateFakeKhachHangView
        (
            Model model,
            @RequestParam Long soLuongPhaiTao
        )

        {
            this.khFakingService1.createAndSaveNfakeKhachHang(soLuongPhaiTao);

            return "redirect:/khachHang/homeView";
        }
}
