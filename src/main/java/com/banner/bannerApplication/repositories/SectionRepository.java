package com.banner.bannerApplication.repositories;

import java.util.Collection;
import com.banner.bannerApplication.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, Long> {
    Collection<Section> findByCourseNumber (String name);
    Collection<Section> findByProfessorId(Long id);
}