package org.zerock.sb7.member.dto;

import lombok.Data;
import org.apache.catalina.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.zerock.sb7.member.domain.Member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class MemberDTO implements UserDetails {

    private String mid;
    private String mpw;
    private String email;
    private boolean del;
    private boolean social;

    private List<String> roleNames;

    public MemberDTO(Member member) {

        this.mid = member.getMid();
        this.mpw = member.getMpw();
        this.email = member.getEmail();
        this.del = member.isDel();
        this.social = member.isSocial();
        this.roleNames = member.getRoleSet().stream().map(role -> role.name()).collect(Collectors.toList());

    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        System.out.println("--------------getAuthorities");

        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {

        System.out.println("--------------getPassword");

        return this.mpw;
    }

    @Override
    public String getUsername() {

        System.out.println("--------------getUsername");

        return this.mid;
    }
}