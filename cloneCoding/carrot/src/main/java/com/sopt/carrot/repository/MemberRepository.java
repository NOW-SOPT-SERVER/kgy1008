package com.sopt.carrot.repository;

import com.sopt.carrot.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
