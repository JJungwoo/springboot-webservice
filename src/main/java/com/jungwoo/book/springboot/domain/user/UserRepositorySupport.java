package com.jungwoo.book.springboot.domain.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.jungwoo.book.springboot.domain.user.QUser.user;

import java.util.List;

@Repository
public class UserRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public UserRepositorySupport(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory = queryFactory;
    }

    public List<User> findByName(String name) {
        return queryFactory
                .selectFrom(user)
                .where(user.name.eq(name))
                .fetch();
    }

}
