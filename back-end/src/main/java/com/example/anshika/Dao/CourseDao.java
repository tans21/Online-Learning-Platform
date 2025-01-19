package com.example.anshika.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.anshika.Entity.CourseDetails;

public interface CourseDao extends JpaRepository <CourseDetails,Integer> {

}
