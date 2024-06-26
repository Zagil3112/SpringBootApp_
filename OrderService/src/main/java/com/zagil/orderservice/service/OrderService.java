package com.zagil.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.zagil.orderservice.dto.InventoryResponse;
import com.zagil.orderservice.dto.OrderLineItemsDto;
import com.zagil.orderservice.dto.OrderRequest;
import com.zagil.orderservice.model.Order;
import com.zagil.orderservice.model.OrderLineItems;
import com.zagil.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
	
	private final OrderRepository orderRepository;
	//private final WebClient webClient;
	
	public void placeOrder(OrderRequest orderRequest) {
		// 
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		order.setPrice(orderRequest.price());
		order.setSkuCode(orderRequest.skuCode());
		order.setQuantity(orderRequest.quantity());
		orderRepository.save(order);
		
		
	}
	
	/*
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);
        List<String> skuCodes = order.getOrderLineItemsList().stream()
        	.map(OrderLineItems::getSkuCode)
        	.toList();
        
		// Call inventory service, and place order if product is in stock
        InventoryResponse[] inventoryResponseArray = webClient.get()
        	.uri("http://localhost:8084/api/inventory",
        			uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
        	.retrieve()
        	.bodyToMono(InventoryResponse[].class)
        	.block();
        
        boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);
        
        if(allProductsInStock) {
        	
        	orderRepository.save(order);
        	
        }
        else {
        	throw new IllegalArgumentException("Product not in stock");
        }
        
		
		
	}

	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }*/
}
