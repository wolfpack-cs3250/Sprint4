package com.banner.bannerApplication.repositories;

import java.util.List;

import com.banner.bannerApplication.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, String> {
    List<User> findByLastName(@Param("name") String name);

}
