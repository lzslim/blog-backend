package com.example.demo.service;

import com.example.demo.dao.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User Select(int id) {
        return userMapper.Select(id);
    }
    
    public List<User> selectAll() {
        return userMapper.selectAll();
    }
}
