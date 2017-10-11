package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Professor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProfessorRepository extends PagingAndSortingRepository<Professor, Long> {
    List<Professor> findByLastName(String name);
}
