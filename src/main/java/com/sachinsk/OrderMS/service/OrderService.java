package com.sachinsk.OrderMS.service;

import com.sachinsk.OrderMS.dto.OrderDTO;
import com.sachinsk.OrderMS.dto.OrderDTOFromFrontEnd;
import com.sachinsk.OrderMS.dto.UserDTO;
import com.sachinsk.OrderMS.entity.Order;
import com.sachinsk.OrderMS.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

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

        //using restTemplate
        //in below whatever we get as a response from url=, i.e passed to UserDTO.class
        UserDTO userDTO = restTemplate.getForObject("http://USER-SERVICE/user/fetchById/" + userId, UserDTO.class);
        return userDTO;
    }
}
