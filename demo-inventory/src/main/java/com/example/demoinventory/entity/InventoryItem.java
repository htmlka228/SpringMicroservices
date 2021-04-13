package com.example.demoinventory.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "inventory")
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uniq_id")
    private String uniqId;

    @Column(name = "quantity")
    private Integer availableQuantity = 0;
}
