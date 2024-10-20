package com.example.hocjpa_hodanit.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping("/admin/order")
    public String home(){
        return "Admin/Order/index";
    }
}
