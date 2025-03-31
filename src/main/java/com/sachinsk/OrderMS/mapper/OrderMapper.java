package com.sachinsk.OrderMS.mapper;

import com.sachinsk.OrderMS.dto.OrderDTO;
import com.sachinsk.OrderMS.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO orderDTO);

    OrderDTO mapOrderToOrderDTO(Order order);
}
