package com.sopt.carrot.service;

import com.sopt.carrot.common.dto.ErrorMessage;
import com.sopt.carrot.domain.Heart;
import com.sopt.carrot.domain.Member;
import com.sopt.carrot.domain.Product;
import com.sopt.carrot.exception.NotFoundException;
import com.sopt.carrot.repository.HeartRepository;
import com.sopt.carrot.repository.MemberRepository;
import com.sopt.carrot.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HeartService {

    private final HeartRepository heartRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void createHeart(Long productId, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.USER_NOT_FOUND)
        );
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND)
        );

        heartRepository.save(Heart.createHeart(member, product));
    }
}
