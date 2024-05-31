package com.sopt.carrot.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Product product;


    @Builder
    public Heart(Member member, Product product) {
        this.member = member;
        this.product = product;
    }

    public static Heart createHeart(Member member, Product product) {
        return Heart.builder()
                .member(member)
                .product(product)
                .build();
    }
}
