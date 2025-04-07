package com.example.demoKDL1.KhachHangBuuDien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class KhachHangBuuDienController {
    
    @Autowired
    KhachHangBuuDienService khdlService1;

    @Autowired
    KhachHangBuuDienFakingService khdlFakingService2;

    @GetMapping(value={"/khbd", "/khbd/homeView"})
    public String getKhbdHomeView(Model model) {
        return "/KhachHangBuuDien/HomeView";
    }

    @GetMapping("/khbd/generateFakeKhbdView")
    public String getGenerateFakeKhbdView(Model model) {
        return "/KhachHangBuuDien/GenerateFakeKhbdView";
    }

    @PostMapping("/khbd/generateFakeKhbdView/sendForm")
    public String postAtGenerateFakeKhbdView
        (
            Model model,
            @RequestParam Long soLuongPhaiTao
        )

        {
            this.khdlFakingService2.createKhbdFromKh(soLuongPhaiTao);
            
            return "redirect:/khbd/homeView";
        }

}
