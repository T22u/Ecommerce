package com.Ecommerce.OrderService.service;

import com.Ecommerce.OrderService.dto.OrderLineItemsDto;
import com.Ecommerce.OrderService.dto.OrderRequest;
import com.Ecommerce.OrderService.model.Order;
import com.Ecommerce.OrderService.model.OrderLineItems;
import com.Ecommerce.OrderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceimpl implements OrderService{

    @Autowired
    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = new ArrayList<>();
        for (OrderLineItemsDto orderLineItemsDto : orderRequest.getOrderLineItemsDtoList()) {
            OrderLineItems lineItems = mapToDto(orderLineItemsDto);
            orderLineItems.add(lineItems);
        }

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
