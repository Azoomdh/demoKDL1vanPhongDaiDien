package com.example.demoKDL1.KhachHangDuLich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class KhachHangDuLichController {
    
    @Autowired
    KhachHangDuLichService khdlService1;

    @Autowired
    KhachHangDuLichFakingService khdlFakingService2;

    @GetMapping(value={"/khdl", "/khdl/homeView"})
    public String getKhdlHomeView(Model model) {
        return "/KhachHangDuLich/HomeView";
    }

    @GetMapping("/khdl/generateFakeKhdlView")
    public String getGenerateFakeKhdlView(Model model) {
        return "/KhachHangDuLich/GenerateFakeKhdlView";
    }

    @PostMapping("/khdl/generateFakeKhdlView/sendForm")
    public String postAtGenerateFakeKhdlView
        (
            Model model,
            @RequestParam Long soLuongPhaiTao
        )

        {
            this.khdlFakingService2.createKhdlFromKh(soLuongPhaiTao);
            
            return "redirect:/khdl/homeView";
        }

}
