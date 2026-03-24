package com.stock.management.controller;

import com.stock.management.entity.Order;
import com.stock.management.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public Order create(@RequestBody List<Integer> ids) {
        return service.create(ids);
    }
}