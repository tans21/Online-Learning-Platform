package com.example.anshika.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.anshika.Dao.CourseDao;
import com.example.anshika.Entity.CourseDetails;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    //Adds a new course to the database
    public CourseDetails addCourse (CourseDetails courseDetails){
        CourseDetails createdCourse = courseDao.save(courseDetails);
                return createdCourse;
    }

    //Retrieves all courses stored in the database
    public List<CourseDetails> getAllCourseDetails() {
        List<CourseDetails> findAll = courseDao.findAll();
        return findAll;
    }

    

}
