package com.newer.dao;

import com.newer.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {


    public User login(@Param("username") String username,@Param("password") String password);

}
