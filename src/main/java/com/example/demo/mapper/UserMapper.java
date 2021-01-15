package com.example.demo.mapper;

import com.example.demo.dao.User;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMapper {

    User Select(int id);
    
    List<User> selectAll();
}
