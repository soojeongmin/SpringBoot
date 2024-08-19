package com.bit.springboard.service.impl;

import com.bit.springboard.dto.BoardDto;
import com.bit.springboard.mapper.FreeMapper;
import com.bit.springboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FreeServiceImpl implements BoardService {
    private final FreeMapper freeMapper;

    @Override
    public BoardDto post(BoardDto boardDto) {
        freeMapper.post(boardDto);
        return freeMapper.findLast();
    }
}
