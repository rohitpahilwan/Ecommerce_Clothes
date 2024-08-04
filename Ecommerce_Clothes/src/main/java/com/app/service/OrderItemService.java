package com.app.service;


import java.util.List;

import com.app.dto.OrderItemDTO;

public interface OrderItemService {

    OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO);

    OrderItemDTO getOrderItemById(Long id);

    List<OrderItemDTO> getAllOrderItems();

    OrderItemDTO updateOrderItem(Long id, OrderItemDTO orderItemDTO);

    void deleteOrderItem(Long id);
}

