package com.sopt.carrot.controller;

import com.sopt.carrot.common.dto.SuccessMessage;
import com.sopt.carrot.common.dto.SuccessStatusResponse;
import com.sopt.carrot.dto.ProductCreateRequest;
import com.sopt.carrot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<SuccessStatusResponse> createProduct(
            @RequestHeader(name = "memberId") Long memberId,
            @RequestHeader(name = "regionId") Long regionId,
            @RequestBody ProductCreateRequest productCreateRequest
            ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", productService.createProduct(memberId, regionId, productCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.PRODUCT_CREATE_SUCCESS.getMessage()));
    }
}
