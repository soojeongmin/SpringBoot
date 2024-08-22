package com.bit.springboard.mapper;

import com.bit.springboard.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FreeMapper {
    void post(BoardDto boardDto);

    BoardDto findLast();
}
