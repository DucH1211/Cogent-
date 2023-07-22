package com.assignment.orderpaymenttransaction.OrderService.controller;

import com.assignment.orderpaymenttransaction.OrderService.entity.OrderDetail;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order-service")
public class OrderServiceController {
    @PostMapping("add-order")
    public String addOrder(@RequestBody OrderDetail orderDetail)
    {
        return null;
    }
}
