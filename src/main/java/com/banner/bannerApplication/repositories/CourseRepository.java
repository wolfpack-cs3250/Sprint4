package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "courses", path = "courses")
public interface CourseRepository extends PagingAndSortingRepository<Course, String> {
    List<Course> findByCourseName(@Param("name") String name);

}
