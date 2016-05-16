package com.xwdc.dao;

import org.springframework.stereotype.Repository;

import com.xwdc.domain.User;

@Repository
public interface UserMapper {

    int insert(User record);

}