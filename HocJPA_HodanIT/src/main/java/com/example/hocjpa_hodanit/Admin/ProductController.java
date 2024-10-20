package com.example.hocjpa_hodanit.Admin;

import com.example.hocjpa_hodanit.Entity.Products;
import com.example.hocjpa_hodanit.Service.ProductServiceImpl;
import com.example.hocjpa_hodanit.Service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin")
public class ProductController {
    private final ProductServiceImpl productService;
    private final UploadFileService uploadFileService;

    @Autowired
    public ProductController( ProductServiceImpl productService,UploadFileService uploadFileService) {
        this.productService = productService;
        this.uploadFileService=uploadFileService;
    }

    @GetMapping("/product")
    public String home(Model model){
        List<Products> product=productService.getAllProduct();
        model.addAttribute("ltsProduct",product);

        return "Admin/Product/index";
    }
    @GetMapping("/product/formAdd")
    public String show(Model model){
       model.addAttribute("Product",new Products());
        return "Admin/Product/showProduct";
    }
    @PostMapping("/product/add")
    public String add(@ModelAttribute("Product") Products product, @RequestParam("File") MultipartFile file) throws IOException {
        String fileName=uploadFileService.uploadFile(file,"Product");
        product.setImage(fileName);
        this.productService.save(product);
        return "redirect:/admin/product";
    }
    @GetMapping("/product/detail")
    public String detail(@RequestParam("id") int id,Model model){
        Products pro=this.productService.getProductById(id);
        model.addAttribute("product",pro);
        return "Admin/Product/DetailProduct";

    }
    @GetMapping("/product/delete/")
    public String delete(@RequestParam("id") int id){
        this.productService.deleteProductById(id);
        return "redirect:/admin/product";

    }
}
