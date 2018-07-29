package com.pearl.tracker.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import lombok.Data;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Data
@Named
@Table(name = "PRODUCT")
@SessionScoped
@NamedQueries({
    @NamedQuery(name = "product.findAll",query = "select p from Product p"),
    @NamedQuery(name = "product.findByProductName",query = "select p from Product p where p.name = :productName"),
    @NamedQuery(name = "product.findByProductId",query = "select p from Product p where p.skuId = :productId")
})
@NamedQuery(name = "findProductByName", query = "select p from Product p where p.name like '%:productName%'")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "products_seq")
    @NotNull
    @Column(name = "SKU_ID")
    private long skuId;

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

    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate = new Date();

    public Product() {
    }

    public Product(long skuId, String name, String description, BigDecimal price, String imageName,Date modifiedDate) {
        this.skuId = skuId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
        this.modifiedDate = modifiedDate;
    }


}
