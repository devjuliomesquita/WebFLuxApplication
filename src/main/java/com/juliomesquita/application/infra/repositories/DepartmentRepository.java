package com.juliomesquita.application.infra.repositories;

import com.juliomesquita.application.domain.entities.DepartmentEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends ReactiveCrudRepository<DepartmentEntity, UUID> {
}
