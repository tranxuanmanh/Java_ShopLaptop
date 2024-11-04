package com.example.hocjpa_hodanit.Client;

import com.example.hocjpa_hodanit.Entity.DTO.RegisterDTO;
import com.example.hocjpa_hodanit.Entity.Products;
import com.example.hocjpa_hodanit.Entity.User;
import com.example.hocjpa_hodanit.Service.ProductService;
import com.example.hocjpa_hodanit.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    @PostMapping("/login")
    public String dangnhap()
    {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String show(Model model,
                       @RequestParam(value="page" ,required = false, defaultValue = "1") Optional<String> page,
                       @RequestParam(value = "name" ,required = false)Optional<String> name){

        List<Products> pros= service.getAllProduct();
        List<Products> dells=service.getProductByName("dell");
        List<Products> macbooks=service.getProductByName("macbook");
        List<Products> hps=service.getProductByName("hp");
        List<Products> gamings=service.getProductByName("gaming");
        int pages=1;
        try{
            if(page.isPresent()){
                pages=Integer.parseInt(page.get());
            }else{
                pages=1;
            }
        }catch (NumberFormatException ex){
            pages=1;
        }

        int totalPage=0;
        if(name.isPresent()) {
            String Name = name.get();
            Pageable pageable = PageRequest.of(pages-1, 2);
            Page<Products> prs = this.service.pageProduct(Name, pageable);
            List<Products> pros2 = prs.getContent();
             totalPage=prs.getTotalPages();
            model.addAttribute("products", pros2);
            model.addAttribute("totalPage",totalPage);
            int prev=pages-1;
            int next=pages+1;
            if(prev<0){
                pages=1;
            }
            if(next>totalPage){
                pages=totalPage;
            }
            model.addAttribute("prev",prev);
            model.addAttribute("next",next);
        }else{
            model.addAttribute("products",pros);
        }
        model.addAttribute("page",pages);
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
