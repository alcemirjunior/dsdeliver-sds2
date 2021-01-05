package com.github.alcemirjunior.dsdelivery.controllers;

import com.github.alcemirjunior.dsdelivery.dto.OrderDTO;
import com.github.alcemirjunior.dsdelivery.dto.ProductDTO;
import com.github.alcemirjunior.dsdelivery.services.OrderService;
import com.github.alcemirjunior.dsdelivery.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll(){ //responseEntity tem a ver com a resposta HTTP. ex.: 200 OK
        List<OrderDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
