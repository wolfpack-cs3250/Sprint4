package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Professor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "professors", path = "professors")
public interface ProfessorRepository extends PagingAndSortingRepository<Professor, String> {
    List<Professor> findByLastName(@Param("name") String name);
}
