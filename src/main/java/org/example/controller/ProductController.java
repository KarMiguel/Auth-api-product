package org.example.controller;


import jakarta.validation.Valid;
import org.example.domain.product.Product;
import org.example.domain.product.ProductRequestDTO;
import org.example.domain.product.ProductResponseDTO;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductRepository repository;

    @PostMapping()
    public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body){
        Product newProduct = new Product(body);

        this.repository.save(newProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping()
    public ResponseEntity getAllProducts(){
        List<ProductResponseDTO> productList = this.repository.findAll().stream().map(ProductResponseDTO::new).toList();

        return ResponseEntity.ok(productList);
    }


}

