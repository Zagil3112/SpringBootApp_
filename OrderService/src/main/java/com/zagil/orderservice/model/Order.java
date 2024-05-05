package com.zagil.orderservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name="t_orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;
	private String orderNumber;
	@OneToMany(cascade = CascadeType.ALL )
	private List<OrderLineItems> orderLineItemsList ;
}
