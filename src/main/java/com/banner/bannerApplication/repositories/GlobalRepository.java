package com.banner.bannerApplication.repositories;

import java.util.List;

import com.banner.bannerApplication.entities.Global;
import org.springframework.data.repository.CrudRepository;

public interface GlobalRepository extends CrudRepository<Global, String> {
    List<Global> findBySchoolName(String schoolName);
}