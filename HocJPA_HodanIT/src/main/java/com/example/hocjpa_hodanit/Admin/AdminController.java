package com.example.hocjpa_hodanit.Admin;

import com.example.hocjpa_hodanit.Entity.Roles;
import com.example.hocjpa_hodanit.Entity.User;
import com.example.hocjpa_hodanit.Service.UploadFileService;
import com.example.hocjpa_hodanit.Service.UserServiceI;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("admin/user")
public class AdminController {
    private final UserServiceI userServiceI;
    private final UploadFileService uploadFileService;
    public final PasswordEncoder passwordEncoder;
    @Autowired
    public AdminController(UserServiceI userServiceI, UploadFileService uploadFileService, PasswordEncoder passwordEncoder) {
        this.userServiceI = userServiceI;
        this.uploadFileService=uploadFileService;
        this.passwordEncoder=passwordEncoder;
    }
    @GetMapping("role")
    public String role(@RequestParam("name") String name){
      Roles role=  userServiceI.getRoleByName(name);
        System.out.println(role);
      return "ListUser";
    }

    @GetMapping("/show")
    public String home(Model model){
        List<User> listUser=userServiceI.getAllUser();
        System.out.println(listUser);
        model.addAttribute("listUser",listUser);
        return "Admin/User/index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("user",new User());
        return "Admin/User/formUser";
    }
    @PostMapping ("/showform")
    public String show(
           @Valid @ModelAttribute("user") User user,
            BindingResult UserBindingResult,
            @RequestParam("File") MultipartFile file
    ) throws IOException {
        List<FieldError> fieldErrors=UserBindingResult.getFieldErrors();
        for(FieldError error:fieldErrors){
            System.out.println("Error: "+error.getField()+" --- "+error.getDefaultMessage());
        }
        if(UserBindingResult.hasErrors()){
            return "Admin/User/formUser";
        }

        String fileName= uploadFileService.uploadFile(file,"Avatar");
        user.setAvatar(fileName);
        user.setRoles(this.userServiceI.getRoleByName(user.getRoles().getName()));
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userServiceI.save(user);
        return "redirect:/admin/user/show";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam("id") Integer id){
        this.userServiceI.deleteUserById(id);
        System.out.println("Xoa thanh cong user co id = "+id);
        return "redirect:/admin/user/show";
    }
    @GetMapping("/detail")
    public String detailUser(@RequestParam("id") Integer id,Model model){
        User user=this.userServiceI.getDetailUser(id);
        model.addAttribute("detailUser",user);
        model.addAttribute("id",id);
        return "Admin/User/detail";

    }
    @GetMapping("/update")
    public String ShowUpdateById(@RequestParam("id") Integer id,Model model){
        User us1=userServiceI.getUserById(id);//Tim 1 user theo id
        model.addAttribute("id",id);
        model.addAttribute("NewUser",us1); //Gan user nay vao trong form update
        return "Admin/User/FormUpdate";
    }
    @PostMapping("/updateUser")
    public String PostUpdateUser(
            @ModelAttribute("NewUser") User us,
            @RequestParam("File") MultipartFile file,
            @RequestParam("existingFile") String existingFile
    ) throws IOException {
        String fileName;
        User user=this.userServiceI.getUserById(us.getId());
        if(user!=null) {
            //user.setId(us.getId());
            user.setFullname(us.getFullname());
            user.setEmail(us.getEmail());
            user.setPhone(us.getPhone());
            user.setAddress(us.getAddress());
            user.setRoles(this.userServiceI.getRoleByName(us.getRoles().getName()));
            if(!file.isEmpty()){//Neu nguoi dung chon file moi , thi cap nhat file moi
                fileName=uploadFileService.uploadFile(file,"Avatar");
            }else{//Neu nguoi dung khong chon thi giu nguyen file cu
                fileName=existingFile;
            }
            user.setAvatar(fileName);

            this.userServiceI.updateUser(user);
        }

        return "redirect:/admin/user/show";

    }
}
