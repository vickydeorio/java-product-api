package br.com.java.product.api.model;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;

public class Product {

    @Id
    @ApiModelProperty(value = "Product ID")
    private Integer id;

    @ApiModelProperty(value = "Product Name")
    private String name;
    @ApiModelProperty(value = "Product Description")
    private String description;
    @ApiModelProperty(value = "Product Price")
    private BigInteger price;
    @ApiModelProperty(value = "Product Brand")
    private String brand;

    public Product() {}

    public Product(String name, String description, Integer price, String brand){
        this.setName(name);
        this.setDescription(description);
        this.setPrice(BigInteger.valueOf(price));
        this.setBrand(brand);
    }

    public Product(Integer id, String name, String description, Integer price, String brand){
        this.id = id;
        this.setName(name);
        this.setDescription(description);
        this.setPrice(BigInteger.valueOf(price));
        this.setBrand(brand);
    }

    @Override
    public String toString() {
        return String.format("[%s] Product %s: description=%s, price=%s, brand=%s",
                getId(), getName(), getDescription(), getPrice(), getBrand());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }
}
