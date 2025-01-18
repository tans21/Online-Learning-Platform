package com.example.anshika.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anshika.Dao.UserDao;
import com.example.anshika.Entity.User;

@Service
public class CreateUserService {

    @Autowired
    private UserDao userDao;

    public User saveUser (User user){
        User details = userDao.save(user);
                return details;
    }


}
