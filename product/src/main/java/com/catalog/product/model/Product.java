package com.catalog.product.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    private Long id;
    private String name;
    private String brand;
    private String madein;
    private float price;

    public Product(String name, String brand, String madein, float price) {
        this.name = name;
        this.brand = brand;
        this.madein = madein;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
