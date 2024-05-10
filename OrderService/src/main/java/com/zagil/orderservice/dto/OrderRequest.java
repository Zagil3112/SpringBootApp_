package com.zagil.orderservice.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record OrderRequest(Long id,String orderNumber,String skuCode,
							BigDecimal price, Integer quantity) {
	
	//private List<OrderLineItemsDto> orderLineItemsDtoList;

}
