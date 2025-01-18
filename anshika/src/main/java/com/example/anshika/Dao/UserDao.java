package com.example.anshika.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.anshika.Entity.User;

@Repository
public interface UserDao extends JpaRepository <User,Integer>  {
    //to get user details by userid
    Optional<User> findByUserid(String userid);

}
