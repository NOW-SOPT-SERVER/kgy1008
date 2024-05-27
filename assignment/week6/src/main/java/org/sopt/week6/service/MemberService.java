package org.sopt.week6.service;

import org.sopt.week6.auth.UserAuthentication;
import org.sopt.week6.common.dto.ErrorMessage;
import org.sopt.week6.common.jwt.JwtTokenProvider;
import org.sopt.week6.domain.Member;
import org.sopt.week6.exception.NotFoundException;
import org.sopt.week6.repository.MemberRepository;
import org.sopt.week6.service.dto.MemberCreateDto;
import org.sopt.week6.service.dto.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.sopt.week6.service.dto.UserJoinResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public UserJoinResponse createMember(
            MemberCreateDto memberCreate
    ) {
        Member member =  Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age());
        memberRepository.save(member);

        Long memberId = member.getId();
        String accessToken = jwtTokenProvider.issueAccessToken(
                UserAuthentication.createUserAuthentication(memberId)
        );
        return UserJoinResponse.of(accessToken, memberId.toString());
    }

    public Member findById(Long memberId){
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );
    }

    public MemberFindDto findMemberById(Long memberId){
        return MemberFindDto.of(memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        ));
    }

    @Transactional
    public void deleteMemberById(Long memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND));
        memberRepository.delete(member);
    }
}
