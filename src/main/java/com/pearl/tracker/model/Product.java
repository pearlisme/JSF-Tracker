package com.pearl.tracker.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Data
@Named
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "ID")
    private long id;

    @NotNull
    @Size(min = 0, max = 50)
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    public Product() {
    }

    public Product(long id, String name, String description, BigDecimal price, String imageName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
    }


}
