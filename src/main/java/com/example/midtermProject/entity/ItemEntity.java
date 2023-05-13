package com.example.midtermProject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Item name is required")
    @Size(min = 2, max = 50, message = "Item name must be between 2 and 50 characters")
    private String itemName;
    @Column(name = "description", columnDefinition = "TEXT", length = 1000)
    private String description;
    @Digits(integer = 10, fraction = 2, message = "Invalid price")
    private String price;
    private String currency;
    private String type;

    public ItemEntity() {
    }

    public ItemEntity(int id, String itemName, String description, String price, String currency, String type) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String owner) {
        this.description = owner;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
