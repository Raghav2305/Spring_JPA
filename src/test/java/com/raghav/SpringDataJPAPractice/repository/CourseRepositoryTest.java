package com.raghav.SpringDataJPAPractice.repository;

import com.raghav.SpringDataJPAPractice.entity.Course;
import com.raghav.SpringDataJPAPractice.entity.Student;
import com.raghav.SpringDataJPAPractice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Mark")
                .lastName("Boost")
                .build();

        Course course = Course.builder()
                .courseTitle("Python (3.10.1) Programming")
                .courseCredit(30)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        Pageable firstPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithTwoRecords).getContent();

        int pages = courseRepository.findAll(firstPageWithTwoRecords).getTotalPages();

        System.out.println("pages = " + pages);

        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Duncan")
                .lastName("Idaho")
                .build();

        Student student = Student.builder()
                .email("ben_martin@gmail.com")
                .firstName("Ben")
                .lastName("Martin")
                .build();

        Course course = Course.builder()
                .courseTitle("Docker & Kubernetes")
                .courseCredit(15)
                .teacher(teacher)
                .build();

        course.addStudents(student);
        courseRepository.save(course);
    }
}