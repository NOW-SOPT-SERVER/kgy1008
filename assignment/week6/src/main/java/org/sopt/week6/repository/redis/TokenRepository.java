package org.sopt.week6.repository.redis;

import org.sopt.week6.domain.redis.Token;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TokenRepository extends CrudRepository<Token, Long> {
    Token findByRefreshToken(final String refreshToken);
}
