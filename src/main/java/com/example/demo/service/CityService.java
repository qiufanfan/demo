package com.example.demo.service;

import com.example.demo.Bean.Account;
import com.example.demo.Bean.City;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService  {
    @Autowired
    CityMapper cityMapper;

    public City getById(Long id){
        return cityMapper.getById(id);
    }
}
