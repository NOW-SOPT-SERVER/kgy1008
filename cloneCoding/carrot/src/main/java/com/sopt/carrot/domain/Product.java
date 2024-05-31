package com.sopt.carrot.domain;

import com.sopt.carrot.dto.ProductCreateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Region region;

    private String productName;

    private int price;

    private String description;

    private String imageUrl;

    @Builder
    public Product(Member member, Region region, String productName, int price, String description, String imageUrl) {
        this.member = member;
        this.region = region;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public static Product createProduct(Member member, Region region, String productName, int price, String description, String imageUrl) {
        return Product.builder()
                .member(member)
                .region(region)
                .productName(productName)
                .price(price)
                .description(description)
                .imageUrl(imageUrl)
                .build();
    }
}
