package com.zagil.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zagil.inventoryservice.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

}
