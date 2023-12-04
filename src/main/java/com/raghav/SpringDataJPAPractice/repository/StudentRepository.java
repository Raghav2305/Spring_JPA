package com.raghav.SpringDataJPAPractice.repository;

import com.raghav.SpringDataJPAPractice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);

    @Query("select s from Student s where s.email = ?1")
    public Student getStudentByEmailAddress(String email);

    @Query("select s.firstName from Student s where s.email = ?1")
    public String getStudentFirstNameByEmailAddress(String email);

    @Query(
            value = "SELECT s.guardian_name FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    public String getGuardianNameByEmailAddress(String email);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    public void updateStudentNameByEmailAddress(String firstName, String email);

    @Transactional
    @Modifying
    @Query(
            value = "delete from tbl_student where email_address = ?1",
            nativeQuery = true
    )
    public void deleteStudentByEmailAddress(String email);
}
