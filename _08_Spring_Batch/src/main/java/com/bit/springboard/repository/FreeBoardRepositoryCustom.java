package com.bit.springboard.repository;

import com.bit.springboard.entity.FreeBoard;
import com.bit.springboard.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FreeBoardRepositoryCustom {
    Page<FreeBoard> searchAll(Pageable pageable, Map<String, String> searchMap);

    Optional<FreeBoard> searchOne(Long id);
}
