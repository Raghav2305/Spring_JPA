package com.raghav.SpringDataJPAPractice.repository;

import com.raghav.SpringDataJPAPractice.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
