package com.zagil.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.zagil.orderservice.dto.OrderLineItemsDto;
import com.zagil.orderservice.dto.OrderRequest;
import com.zagil.orderservice.model.Order;
import com.zagil.orderservice.model.OrderLineItems;
import com.zagil.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional	
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

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
