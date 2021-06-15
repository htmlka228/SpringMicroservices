package com.example.demoinventory.controller;

import com.example.demoinventory.entity.InventoryItem;
import com.example.demoinventory.repository.InventoryItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/inventory")
public class InventoryController {
    private final InventoryItemRepository inventoryItemRepository;

    @GetMapping
    public List<InventoryItem> getInventory(){
        return inventoryItemRepository.findAll();
    }

}
