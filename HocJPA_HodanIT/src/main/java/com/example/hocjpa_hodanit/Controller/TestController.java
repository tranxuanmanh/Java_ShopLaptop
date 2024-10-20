package com.example.hocjpa_hodanit.Controller;

import com.example.hocjpa_hodanit.Entity.User;
import com.example.hocjpa_hodanit.Service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestController {
    private UserServiceI userServiceI;
    @Autowired
    public TestController(UserServiceI userServiceI) {
        this.userServiceI = userServiceI;
    }

//    @GetMapping("/create")
//    public String create(Model model){
//        model.addAttribute("user",new User());
//        return "formUser";
//    }
//    @GetMapping("/show")
//    public String show(@ModelAttribute("user") User user,Model model){
//
//        User us1=userServiceI.save(user);
//        model.addAttribute("us1",us1);
//
//        return "redirect:/findAll";
//    }
//    @GetMapping("/findAll")
//    public String findAll(Model model){
//
//        List<User>  us1=this.userServiceI.getAllUser();
//        model.addAttribute("listuser",us1);
//        return "ListUser";
//    }
//    @GetMapping("/delete")
//    public String deleteById(@RequestParam("id") Integer id){
//        this.userServiceI.deleteUserById(id);
//        System.out.println("Xoa thanh cong user co id = "+id);
//        return "redirect:/findAll";
//    }
//    @GetMapping("/detail")
//    public String detailUser(@RequestParam("id") Integer id,Model model){
//        User user=this.userServiceI.getDetailUser(id);
//        model.addAttribute("detailUser",user);
//        model.addAttribute("id",id);
//        return "detail";
//
//    }
//    @GetMapping("/update")
//    public String ShowUpdateById(@RequestParam("id") Integer id,Model model){
//        User us1=userServiceI.getUserById(id);//Tim 1 user theo id
//        model.addAttribute("id",id);
//        model.addAttribute("NewUser",us1); //Gan user nay vao trong form update
//        return "FormUpdate";
//    }
//    @PostMapping("/updateUser")
//    public String PostUpdateUser(@ModelAttribute("NewUser") User us){
//            User user=this.userServiceI.getUserById(us.getId());
//            if(user!=null) {
//                //user.setId(us.getId());
//                user.setFullname(us.getFullname());
//                user.setEmail(us.getEmail());
//                user.setPhone(us.getPhone());
//                user.setAddress(us.getAddress());
//                this.userServiceI.updateUser(user);
//            }
//
//        return "redirect:/findAll";
//
//    }


}
