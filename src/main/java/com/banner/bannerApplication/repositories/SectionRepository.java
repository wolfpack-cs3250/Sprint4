package com.banner.bannerApplication.repositories;

import java.util.List;

import com.banner.bannerApplication.entities.Section;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "section", path = "section")
public interface SectionRepository extends PagingAndSortingRepository<Section, Integer> {
    List<Section> findBySectionNumber (@Param("section") String sectionNumber);
}