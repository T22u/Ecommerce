package com.Ecommerce.OrderService.service;

import com.Ecommerce.OrderService.dto.OrderRequest;

public interface OrderService {
    void placeOrder(OrderRequest orderRequest);
}
