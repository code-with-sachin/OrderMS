package com.sachinsk.OrderMS.service;

import com.sachinsk.OrderMS.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
}
