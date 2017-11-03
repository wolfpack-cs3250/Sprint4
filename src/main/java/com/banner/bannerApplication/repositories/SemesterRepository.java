package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Semester;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "semester", path = "semester")
public interface SemesterRepository extends PagingAndSortingRepository<Semester, Long> {

}