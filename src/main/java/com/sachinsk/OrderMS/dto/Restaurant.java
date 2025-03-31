package com.sachinsk.OrderMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    //This is a restaurant DTO

    private int restaurantId;
    private String restaurantName;
    private String address;
    private String city;
    private String restaurantDescription;


}
