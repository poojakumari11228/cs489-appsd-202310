package com.docker.myapplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @GetMapping
    List<Product> getAllProducts(){
        return List.of(
          new Product(1L, "Dell Laptop", 1000.3),
          new Product(2L, "HP", 2003.43),
          new Product(3L, "Huawei", 2344.4)
        );
    }
}
