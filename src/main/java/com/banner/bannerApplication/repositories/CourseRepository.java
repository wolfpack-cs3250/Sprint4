package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
  
    Optional<Course> findByCourseName(String courseName);

}
