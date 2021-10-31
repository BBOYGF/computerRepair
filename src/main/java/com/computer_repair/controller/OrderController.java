package com.computer_repair.controller;


import com.computer_repair.pojo.Order;
import com.computer_repair.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author guofan
 * @since 2021-10-31
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping("/getAll")
    public List<Order> getAll() {
        return orderService.list();
    }
}
