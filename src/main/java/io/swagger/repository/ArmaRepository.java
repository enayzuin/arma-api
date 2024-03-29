package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.entity.ArmaEntity;

@Repository
public interface ArmaRepository extends JpaRepository<ArmaEntity, Long> {

}
