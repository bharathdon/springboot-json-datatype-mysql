package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.model.CustomEntity;

@Repository
public interface CustomEntityRepository extends JpaRepository<CustomEntity, Integer> {

}
