package com.bit.springboard.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDateTime;

@Entity
//@Table(name="T_MEMBER")
@Getter
@Setter
@DynamicInsert // null 값은 default 값으로 대체
public class Member {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(unique = true, length=20)
    private String username;

    @Column(length=300)
    private String password;

    @Column(length=50)
    private String email;

    @Column(unique = true, length=50)
    private String nickname;

    @Column(length=20)
    private String tel;

    @ColumnDefault("'ROLE_USER'")
    private String role;

//    @Transient
//    private LocalDateTime Regdate;
    // java에서만 쓸 필드는 @Transient를 붙여준다.
}
