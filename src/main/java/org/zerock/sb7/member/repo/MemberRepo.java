package org.zerock.sb7.member.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.sb7.member.domain.Member;

public interface MemberRepo extends JpaRepository<Member, String> {
}