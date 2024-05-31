package com.sopt.carrot.controller;

import com.sopt.carrot.common.dto.SuccessMessage;
import com.sopt.carrot.common.dto.SuccessStatusResponse;
import com.sopt.carrot.dto.ProductCreateRequest;
import com.sopt.carrot.service.ProductService;
import jakarta.validation.Valid;
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
            @ModelAttribute ProductCreateRequest productCreateRequest
            ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", productService.createProduct(memberId, regionId, productCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.PRODUCT_CREATE_SUCCESS.getMessage()));
    }

    @GetMapping("/products/{regionId}")
    public ResponseEntity<SuccessStatusResponse> getProduct(
            @PathVariable Long regionId
    ) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessStatusResponse.of(
                        SuccessMessage.PRODUCT_GET_SUCCESS.getMessage(),
                        productService.getProductByRegionId(regionId)));
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<SuccessStatusResponse> deleteProduct(
            @PathVariable Long productId,
            @RequestHeader Long memberId
    ) {
        productService.deleteProduct(productId, memberId);
        return ResponseEntity.ok(SuccessStatusResponse.of(SuccessMessage.PRODUCT_DELETE_SUCCESS.getMessage()));
    }
}
