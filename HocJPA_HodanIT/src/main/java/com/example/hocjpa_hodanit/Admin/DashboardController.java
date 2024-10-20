package com.example.hocjpa_hodanit.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
    @GetMapping("/admin/home")
    public String home(){
        return "Admin/Dashboard/index";
    }
}
