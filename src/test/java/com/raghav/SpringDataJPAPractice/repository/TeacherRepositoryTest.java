package com.raghav.SpringDataJPAPractice.repository;

import com.raghav.SpringDataJPAPractice.entity.Course;
import com.raghav.SpringDataJPAPractice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    public void addCoursesIntoList(String title, int credits, List<Course> courseList){

        courseList.add(Course.builder()
                        .courseTitle(title)
                        .courseCredit(credits)
                        .build());
    }

    @Test
    public void saveTeacher(){
        List<Course> courses = new ArrayList<>();

        addCoursesIntoList("Java Full stack", 50, courses);
        addCoursesIntoList("Blockchain Development", 40, courses);
        addCoursesIntoList("Machine Learning: NLP", 60, courses);



        Course course = Course.builder()
                .courseTitle("Java Full stack")
                .courseCredit(50)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("Smith")
//                .courses(courses)
                .build();

        teacherRepository.save(teacher);
    }
}