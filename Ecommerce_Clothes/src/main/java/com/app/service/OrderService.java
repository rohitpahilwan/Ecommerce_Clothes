package com.app.service;


import java.util.List;

import com.app.dto.OrderDTO;

public interface OrderService {

    com.app.dto.OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO getOrderById(Long id);

    List<OrderDTO> getAllOrders();

    OrderDTO updateOrder(Long id, OrderDTO orderDTO);

    void deleteOrder(Long id);
}
