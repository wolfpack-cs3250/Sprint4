package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Buildings;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "buildings", path = "buildings")
public interface BuildingRepository extends PagingAndSortingRepository<Buildings, String> {
    List<Buildings> findByBuildingName(@Param("name") String name);
}