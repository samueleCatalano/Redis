package com.redis.com.redis.repositories;

import com.redis.com.redis.entities.jpa.UserJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserJPARepository extends JpaRepository<UserJPA, String> {
}
