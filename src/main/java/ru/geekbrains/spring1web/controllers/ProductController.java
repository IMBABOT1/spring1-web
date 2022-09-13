package ru.geekbrains.spring1web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.spring1web.entities.Product;
import ru.geekbrains.spring1web.services.ProductService;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public String showStudentsPage(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products_page";
    }

    @GetMapping("/products/{id}")
    public String showStudentPage(Model model, @PathVariable Long id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }
}

