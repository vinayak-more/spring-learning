package com.spittr.web.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Vinayak More
 *
 * @date 17-Jul-2017
 * 
 * 
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 2080109569312281483L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "seller_id")
    private Long sellerId;

    @NotNull
    @Size(min = 5, max = 1000, message = "{productName.size}")
    @Column(name = "name", nullable = false, length = 1000)
    private String name;

    @NotNull
    @Size(min = 1, max = 1000, message = "{productId.size}")
    @Column(name = "product_id", nullable = false, length = 100)
    private String productId;

    @Column(name = "image_path", length = 10000)
    private String imagePath;

    @NotNull(message = "{productHeight.digits}")
    @Column(name = "height")
    private Double height;

    @Column(name = "length")
    private Double length;

    @Column(name = "width")
    private Double width;

    @NotNull(message = "{productPrice.digits}")
    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description", length = 20000)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", sellerId=" + sellerId + ", name=" + name + ", productId=" + productId
                + ", imagePath=" + imagePath + ", height=" + height + ", length=" + length + ", width=" + width
                + ", price=" + price + ", description=" + description + "]";
    }

}
