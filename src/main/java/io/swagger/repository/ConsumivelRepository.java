package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.entity.ConsumivelEntity;

@Repository
public interface ConsumivelRepository extends JpaRepository<ConsumivelEntity, Long> {

}
