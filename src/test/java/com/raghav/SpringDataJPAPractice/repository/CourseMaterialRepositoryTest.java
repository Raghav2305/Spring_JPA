package com.raghav.SpringDataJPAPractice.repository;

import com.raghav.SpringDataJPAPractice.entity.Course;
import com.raghav.SpringDataJPAPractice.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .courseTitle("MERN Stack")
                .courseCredit(10)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .courseUrl("http://udemy.com/course/mern_stack")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }
    @Test
    public void getAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("courseMaterialList = " + courseMaterialList);
    }
}