package com.example.hocjpa_hodanit.Client;

import com.example.hocjpa_hodanit.Entity.DTO.RegisterDTO;
import com.example.hocjpa_hodanit.Entity.Products;
import com.example.hocjpa_hodanit.Entity.User;
import com.example.hocjpa_hodanit.Service.ProductService;
import com.example.hocjpa_hodanit.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ClientController {
    private final ProductService service;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public ClientController(ProductService service,UserService userService,PasswordEncoder passwordEncoder) {
        this.userService=userService;
        this.passwordEncoder=passwordEncoder;
        this.service = service;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("register",new RegisterDTO());
        return "/Client/Auth/register";
    }
    @PostMapping("/register")
    public String register2(@ModelAttribute("register") @Valid  RegisterDTO RegisterDTO
    , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "/Client/Auth/register";
        }
        User user=this.userService.RegisterDTOtoUser(RegisterDTO);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        user.setRoles(this.userService.getRoleByName("USER"));
        user.setAddress("Nam Dinh");
        user.setPhone("1234567890");
        this.userService.save(user);

        return "/Client/Auth/login";
    }
    @GetMapping("/login")
    public String login(){
        return "/Client/Auth/login";
    }

    @GetMapping("/home")
    public String show(Model model){
        List<Products> pros= service.getAllProduct();
        List<Products> dells=service.getProductByName("dell");
        List<Products> macbooks=service.getProductByName("macbook");
        List<Products> hps=service.getProductByName("hp");
        List<Products> gamings=service.getProductByName("gaming");
        model.addAttribute("products",pros);
        model.addAttribute("lstDell",dells);
        model.addAttribute("lstMac",macbooks);
        model.addAttribute("lstHp",hps);
        model.addAttribute("lstGame",gamings);
        return "Client/HomePage/show";
    }
    @GetMapping("/cart")
    public String cart(){
        return "Client/HomePage/Cart";
    }
    @GetMapping("/shop")
    public String shop(Model model){
        List<Products> pros= service.getAllProduct();
        model.addAttribute("products",pros);
        return "Client/HomePage/shop";
    }
    @GetMapping("/shopDetail")
    public String shopDetails(Model model, @RequestParam("id") int id) {
        Products product=service.getProductById(id);
        model.addAttribute("product",product);
        List<Products> pros= service.getAllProduct();
        Collections.shuffle(pros);//Tron ngau nhien
       List<Products> pros2= pros.subList(0,4);
        model.addAttribute("products",pros2);//Có 4 phần tử ngẫu nhiên trong list
        return "Client/HomePage/shopDetails";
    }
    @GetMapping("/checkout")
    public String checkout(){
        return "Client/HomePage/CheckOut";
    }
}
