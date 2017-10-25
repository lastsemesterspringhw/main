package com.example.finish.service;

import com.example.finish.repo.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean suchUserExistsOrNot(String name, String password) {

        ArrayList list = (ArrayList) jdbcTemplate.queryForList("SELECT * FROM Administrator WHERE name = '"+name+"' AND password = '"+password+"'");
        if (list.size() == 1){
            return true;
        }
        return false;
    }
}
