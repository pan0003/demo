package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController 
{
    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public String show(@PathVariable int id, Model model)
    {
        Product product = productService.findById(id);
        model.addAttribute(product);
        return "product";
    }

    //TODO: Either implement admin controls or remove these methods.
    //@RequestMapping(value = "/product", methd = {RequestMethod.POST, RequestMethod.PUT})

    public String createOrUpdate(@Valid Product product)
        {
            productService.save(product);
            return "redirect:/product/" + product.getId();
        }
}

