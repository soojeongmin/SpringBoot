package com.bit.springboard.repository;

import com.bit.springboard.entity.NoticeFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoticeFileRepository extends JpaRepository<NoticeFile, Long> {
    Optional<NoticeFile> findByNoticeId(Long id);
}
