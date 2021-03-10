package com.example.demo.service;

import com.example.demo.Bean.Account;
import com.example.demo.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountMapper accountMapper;

    public Account getById(Long id){
        return accountMapper.getId(id);
    }
}
