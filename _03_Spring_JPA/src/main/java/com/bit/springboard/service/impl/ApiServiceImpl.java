package com.bit.springboard.service.impl;

import com.bit.springboard.dto.MemberDto;
import com.bit.springboard.entity.Member;
import com.bit.springboard.repository.MemberRepository;
import com.bit.springboard.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiServiceImpl implements ApiService {
    private final MemberRepository memberRepository;


    @Override
    public Member save(MemberDto memberDto) {
        Member member = new Member();
        member.setUsername(memberDto.getUsername());
        member.setPassword(memberDto.getPassword());
        member.setEmail(memberDto.getEmail());
        member.setNickname(memberDto.getNickname());
        member.setTel(memberDto.getTel());
        return memberRepository.save(member);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member modify(Long id, MemberDto memberDto) {
        Member member = memberRepository.findById(id).orElseThrow();
        member.setPassword(memberDto.getPassword());
        member.setEmail(memberDto.getEmail());
        member.setNickname(memberDto.getNickname());
        member.setTel(memberDto.getTel());
        return memberRepository.save(member);
    }


}
