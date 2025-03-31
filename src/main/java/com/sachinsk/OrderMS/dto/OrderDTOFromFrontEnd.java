package com.sachinsk.OrderMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFrontEnd {

    private List<FoodItems> foodItemsList;
    private Integer userId;
    private Restaurant restaurant;
}
