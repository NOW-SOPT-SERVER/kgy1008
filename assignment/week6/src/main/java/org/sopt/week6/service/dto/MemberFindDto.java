package org.sopt.week6.service.dto;

import org.sopt.week6.domain.Member;
import org.sopt.week6.domain.Part;

public record MemberFindDto(
        String name,
        Part part,
        int age
) {
    public static MemberFindDto of(Member member) {
        return new MemberFindDto(member.getName(), member.getPart(), member.getAge());
    }
}
