package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Optional<Professor> findByFirstName(String firstName);
}
