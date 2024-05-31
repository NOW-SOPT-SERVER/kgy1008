package com.sopt.carrot.service;

import com.sopt.carrot.common.dto.ErrorMessage;
import com.sopt.carrot.domain.Product;
import com.sopt.carrot.domain.Region;
import com.sopt.carrot.domain.Member;
import com.sopt.carrot.dto.ProductCreateRequest;
import com.sopt.carrot.dto.ProductGetResponse;
import com.sopt.carrot.exception.NotFoundException;
import com.sopt.carrot.external.S3Service;
import com.sopt.carrot.repository.ProductRepository;
import com.sopt.carrot.repository.RegionRepository;
import com.sopt.carrot.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final RegionRepository regionRepository;
    private final S3Service s3Service;

    private static final String PRODUCT_S3_UPLOAD_FOLDER = "product/";

    @Transactional
    public String createProduct(Long memberId, Long regionId, ProductCreateRequest productCreateRequest) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.USER_NOT_FOUND)
        );

        Region region = regionRepository.findById(regionId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.REGION_NOT_FOUND)
        );

        try {
            Product product = Product.createProduct(
                    member,
                    region,
                    productCreateRequest.title(),
                    productCreateRequest.price(),
                    productCreateRequest.description(),
                    s3Service.uploadImage(PRODUCT_S3_UPLOAD_FOLDER, productCreateRequest.image())
            );
            productRepository.save(product);
            return product.getId().toString();
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<ProductGetResponse> getProductByRegionId(Long regionId) {
        List<Product> products = productRepository.findAllByRegionId(regionId);
        return products.stream()
                .map(ProductGetResponse::of)
                .toList();
    }
}
