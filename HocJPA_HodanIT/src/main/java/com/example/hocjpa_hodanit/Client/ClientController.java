package com.example.hocjpa_hodanit.Client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class ClientController {
    @GetMapping("/home")
    public String show(){
        return "Client/HomePage/show";
    }
    @GetMapping("/cart")
    public String cart(){
        return "Client/HomePage/Cart";
    }
    @GetMapping("/shop")
    public String shop(){
        return "Client/HomePage/shop";
    }
    @GetMapping("/shopDetail")
    public String shopDetails() {
        return "Client/HomePage/shopDetails";
    }
    @GetMapping("/checkout")
    public String checkout(){
        return "Client/HomePage/CheckOut";
    }
}
