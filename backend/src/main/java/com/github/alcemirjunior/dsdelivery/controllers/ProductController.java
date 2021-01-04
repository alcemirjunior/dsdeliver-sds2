package com.github.alcemirjunior.dsdelivery.controllers;

import com.github.alcemirjunior.dsdelivery.dto.ProductDTO;
import com.github.alcemirjunior.dsdelivery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){ //responseEntity tem a ver com a resposta HTTP. ex.: 200 OK
        List<ProductDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
