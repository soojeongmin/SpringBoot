package com.bit.springboard.repository;

import com.bit.springboard.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUsernameAndEmail(String username, String email);

    List<Member> findByUsernameOrEmail(String username, String email);

    List<Member> findByUsernameStartingWith(String prefix);
    List<Member> findByUsernameEndingWith(String suffix);
    List<Member> findByUsernameContaining(String username);

    List<Member> findByIdBetween(Long startId, Long endId);

    Page<Member> findAllByOrderByIdDesc(Pageable pageable);

    long countByUsername(String username);

    long countByNickname(String nickname);

    Optional<Member> findByUsernameAndPassword(String username, String password);

    Member findByNickname(String nickname);

//    @Query("SELECT m FROM Member m WHERE m.email = :email")
//    List<Member> findByEmail(@Param("email") String email);

    @Query("SELECT m FROM Member m WHERE m.email = :email")
    List<Member> findByEmail(String email);

    @Query("select m from Member m where m.id > :id and m.nickname like concat('%', :nickname, '%')")
    List<Member> findBiggerThanNicknameContaining(@Param("id") Long id,
                                                  @Param("nickname") String nickname);

}
