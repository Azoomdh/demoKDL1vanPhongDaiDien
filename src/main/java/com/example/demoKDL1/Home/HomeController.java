package com.example.demoKDL1.Home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value={"/", "/homeView"})
    public String getHomeView(Model model){
        return "HomeView";
    }
}
