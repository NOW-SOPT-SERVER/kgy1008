package com.sopt.carrot.repository;

import com.sopt.carrot.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByRegionId(Long regionId);
}
