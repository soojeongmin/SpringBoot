package com.bit.springboard.service;

import com.bit.springboard.dto.MemberDto;
import com.bit.springboard.entity.Member;

import java.util.List;

public interface ApiService {
    Member save(MemberDto memberDto);

    List<Member> findAll();

    Member findById(Long id);

    void deleteById(Long id);

    Member modify(Long id, MemberDto memberDto);
}
