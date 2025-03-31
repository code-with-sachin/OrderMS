package com.sachinsk.OrderMS.entity;

import com.sachinsk.OrderMS.dto.FoodItems;
import com.sachinsk.OrderMS.dto.Restaurant;
import com.sachinsk.OrderMS.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")       //for mongo
public class Order {

    private Integer orderId;

    private List<FoodItems> foodItemsList;
    //since order is also going to have restaurant details
    private Restaurant restaurant;
    //order is also going to have user information
    private UserDTO userDTO;

    //Note: basically 3 inner Jsons will be there in the response. that makes the complete Order that needs to be saved in MongoDB
}
