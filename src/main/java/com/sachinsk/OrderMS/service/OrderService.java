package com.sachinsk.OrderMS.service;

import com.sachinsk.OrderMS.dto.OrderDTO;
import com.sachinsk.OrderMS.dto.OrderDTOFromFrontEnd;
import com.sachinsk.OrderMS.dto.UserDTO;
import com.sachinsk.OrderMS.entity.Order;
import com.sachinsk.OrderMS.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    public OrderDTO saveOrderInDB(OrderDTOFromFrontEnd orderDetailsReceived) {
        //our task is to pass the foodItemsList & restaurant from OrderDTOFromFrontEnd
        //And also fetch the complete user details using the userId received in OrderDTOFromFrontEnd

        //Lets create the order id first
        Integer newOrderId = sequenceGenerator.generateNextOrderId();

        //code to fetch orderDetails from UserId
        UserDTO userDTO = fetchOrderDetailsfromUserId(orderDetailsReceived.getUserId());

        Order orderToBeSaved = new Order(newOrderId,
                orderDetailsReceived.getFoodItemsList(),
                orderDetailsReceived.getRestaurant(),
                userDTO);

        return null;

    }

    private UserDTO fetchOrderDetailsfromUserId(Integer userId) {
        return null;
    }
}
