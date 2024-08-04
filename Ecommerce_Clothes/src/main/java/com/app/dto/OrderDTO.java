package com.app.dto;


import java.util.List;

public class OrderDTO {

    private Long id;
    private UserDTO user;
    private List<OrderItemDTO> items;
    private AddressDTO shippingAddress;
    private AddressDTO billingAddress;
    private Double totalAmount;

    // Getters and Setters
}
