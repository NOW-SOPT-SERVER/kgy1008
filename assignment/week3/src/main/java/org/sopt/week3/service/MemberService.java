package org.sopt.week3.service;

import org.sopt.week3.common.dto.ErrorMessage;
import org.sopt.week3.domain.Member;
import org.sopt.week3.exception.NotFoundException;
import org.sopt.week3.repository.MemberRepository;
import org.sopt.week3.service.dto.MemberCreateDto;
import org.sopt.week3.service.dto.MemberFindDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public String createMember(
            final MemberCreateDto memberCreateDto
    ){
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age());
        memberRepository.save(member);
        return member.getId().toString();
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
