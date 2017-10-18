package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;

public interface RoomsRepository extends JpaRepository<Rooms, Long> {
    Collection<Rooms> findByRoomNumber(String roomNumber);
    Collection<Rooms> findByBuildingsId(Long id);
}