package com.example.anshika.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anshika.Dao.UserDao;
import com.example.anshika.Entity.User;

@Service
public class ValidateLoginService {
    
    //@Autowired, Injects the dependency of the UserDao into the ValidateLoginService
    //it essentially means connecting the service layer to the DAO layer
    //Dependency Injection in ValidateLoginService
    //Here, UserDao is injected into ValidateLoginService.
    @Autowired
    private UserDao userDao;

    //Calling DAO Layer Methods
    //Inside validateLogin, when you call, userid, it delegates the task of fetching the user record to the DAO layer, which handles the actual database query
    public Optional<User> validateLogin(User user){
        if(user.getUserid() == null) {
            throw new IllegalArgumentException();
        }
        Optional<User> findByUserid = userDao.findByUserid(user.getUserid());
        return findByUserid;
    }

}
 