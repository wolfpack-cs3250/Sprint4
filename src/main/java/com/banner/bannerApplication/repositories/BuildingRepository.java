package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Buildings;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BuildingRepository extends JpaRepository<Buildings, Long> {

    Optional<Buildings> findByBuildingName(String buildingName);

}
