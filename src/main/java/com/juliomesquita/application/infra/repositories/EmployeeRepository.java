package com.juliomesquita.application.infra.repositories;

import com.juliomesquita.application.domain.entities.EmployeeEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<EmployeeEntity, UUID> {
}
