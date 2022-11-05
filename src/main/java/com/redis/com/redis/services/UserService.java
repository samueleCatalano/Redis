package com.redis.com.redis.services;

import com.redis.com.redis.entities.jpa.UserJPA;
import com.redis.com.redis.entities.redis.UserRedis;
import com.redis.com.redis.repositories.UserJPARepository;
import com.redis.com.redis.repositories.UserRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserJPARepository userJPARepository;
    @Autowired
    UserRedisRepository userRedisRepository;

    public List<UserJPA> get() {
      return   userJPARepository.findAll();
    }

    public UserJPA post(UserJPA userJPA) {
        return userJPARepository.save(userJPA);
    }

    public void update(String id, UserJPA userJPA) {
        userJPA.setId(id);
        Optional<UserRedis> userRedis = userRedisRepository.findById(id);
        if(userRedis.isPresent()){
            userRedisRepository.deleteById(id);
        }
    }

    public void delete(String id) {
        userJPARepository.deleteById(id);
        userRedisRepository.deleteById(id);
    }
}
