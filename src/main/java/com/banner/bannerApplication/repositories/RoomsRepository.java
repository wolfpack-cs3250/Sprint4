package com.banner.bannerApplication.repositories;

import com.banner.bannerApplication.entities.Rooms;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface RoomsRepository extends PagingAndSortingRepository<Rooms, Long> {
    List<Rooms> findByRoomNumber(@Param("room_number") String roomNumber);
}