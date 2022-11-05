package com.redis.com.redis.repositories;

import com.redis.com.redis.entities.redis.UserRedis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableRedisRepositories
public interface UserRedisRepository extends JpaRepository<UserRedis, String> {
}
