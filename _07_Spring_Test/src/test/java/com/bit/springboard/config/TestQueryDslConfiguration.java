package com.bit.springboard.config;

import com.bit.springboard.repository.FreeBoardRepository;
import com.bit.springboard.repository.impl.FreeBoardRepositoryCustomImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestQueryDslConfiguration {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }

    @Bean
    public FreeBoardRepositoryCustomImpl freeBoardRepository() {
        return new FreeBoardRepositoryCustomImpl(jpaQueryFactory());
    }
}
