package com.xcclass.ehcache1.Service.impl;

import com.xcclass.ehcache1.Entity.User;
import com.xcclass.ehcache1.Service.UserService;
import com.xcclass.ehcache1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "userCache")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Cacheable
    public User getList(Long id) {
        User user = userMapper.getUser(id);
        return user ;
    }
}
