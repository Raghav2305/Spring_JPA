package com.raghav.SpringDataJPAPractice.repository;

import com.raghav.SpringDataJPAPractice.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
