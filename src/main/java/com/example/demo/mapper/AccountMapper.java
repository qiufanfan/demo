package com.example.demo.mapper;

import com.example.demo.Bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper{
    public Account getId(Long id);
}
