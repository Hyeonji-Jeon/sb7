package org.zerock.sb7.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zerock.sb7.member.domain.Member;
import org.zerock.sb7.member.dto.MemberDTO;
import org.zerock.sb7.member.repo.MemberRepo;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService  implements UserDetailsService {

    private final MemberRepo memberRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername: " + username);

        Member member = memberRepo.selectOne(username);

        if(member == null) {
            throw new UsernameNotFoundException(username);
        }

        MemberDTO memberDTO = new MemberDTO(member);

        return memberDTO;

//        UserDetails sampleUser = User.builder()
//                .username(username)
//                .password("$2a$10$qctiG3YhmGgI31UzbEsXuuG1n1wN0O4O0n9aroQqrRW7Z/jEgeNUO")
//                .roles("USER")
//                .build();
//
//        return sampleUser;
    }
}