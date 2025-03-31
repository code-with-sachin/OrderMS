package com.sachinsk.OrderMS.controller;

import com.sachinsk.OrderMS.dto.OrderDTO;
import com.sachinsk.OrderMS.dto.OrderDTOFromFrontEnd;
import com.sachinsk.OrderMS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    //save order in MongoDB
    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFrontEnd orderDetailsReceived) {
        OrderDTO orderSavedInDB = orderService.saveOrderInDB(orderDetailsReceived);
        return new ResponseEntity<>(orderSavedInDB, HttpStatus.CREATED);
    }
}
