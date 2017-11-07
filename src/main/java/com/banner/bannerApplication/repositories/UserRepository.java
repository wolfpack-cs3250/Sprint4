package com.banner.bannerApplication.repositories;


import java.util.List;
import com.banner.bannerApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.TypedQuery;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByLastName(@Param("name") String name);
    User findByFirstName(@Param("name")String name);
    //String findByFirstName(@Param("name") String name);
}