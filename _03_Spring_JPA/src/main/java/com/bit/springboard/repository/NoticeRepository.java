package com.bit.springboard.repository;

import com.bit.springboard.entity.FreeBoard;
import com.bit.springboard.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Optional<Notice> findByTitle(String title);

    List<Notice> findByMemberUsername(String username);

    Page<Notice> findByTitleContainingOrContentContainingOrMemberNicknameContaining(Pageable pageable, String searchKeyword, String searchKeyword1, String searchKeyword2);

    Page<Notice> findByTitleContaining(Pageable pageable, String searchKeyword);

    Page<Notice> findByContentContaining(Pageable pageable, String searchKeyword);

    Page<Notice> findByMemberNicknameContaining(Pageable pageable, String searchKeyword);
}
