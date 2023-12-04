package com.raghav.SpringDataJPAPractice.repository;

import com.raghav.SpringDataJPAPractice.entity.Guardian;
import com.raghav.SpringDataJPAPractice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .email("raghav@gmail.com")
                .firstName("Raghav")
                .lastName("Kavimandan")
//                .guardianName("God")
//                .guardianEmail("godisgreat@heaven.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);

    }
    @Test
    public void saveStudentWithGuardianDetails(){
        Guardian guardian = Guardian.builder()
                .name("Parents")
                .mobile("1234567891")
                .email("parents@gmail.com")
                .build();

        Student student = Student.builder()
                .firstName("Raghav")
                .lastName("Kavimandan")
                .email("raghav23@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void getStudentsByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Raghav");

        System.out.println(students);

    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("raghav23@gmail.com");

        System.out.println("student = " + student);
    }
    @Test
    public void getStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("raghav23@gmail.com");

        System.out.println("firstName = " + firstName);
    }

    @Test
    public void getGuardianNameByEmailAddress(){
        String guardianName = studentRepository.getGuardianNameByEmailAddress("raghav@gmail.com");

        System.out.println("guardianName = " + guardianName);
    }

    @Test
    public void updateStudentNameByEmailAddress(){
        studentRepository.updateStudentNameByEmailAddress("Raghav Kavimandan", "raghav@gmail.com");

    }

    @Test
    public void deleteStudentByEmailAddress(){
        studentRepository.deleteStudentByEmailAddress("raghav23@gmail.com");
    }
}