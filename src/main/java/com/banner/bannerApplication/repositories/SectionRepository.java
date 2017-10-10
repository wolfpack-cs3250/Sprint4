package com.banner.bannerApplication.repositories;

import java.util.Collection;

import com.banner.bannerApplication.entities.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface SectionRepository extends JpaRepository<Section, Long> {
    Collection<Section> findByCourseNumber (String name);
}