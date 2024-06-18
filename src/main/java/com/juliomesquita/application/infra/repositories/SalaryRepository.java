package com.juliomesquita.application.infra.repositories;

import com.juliomesquita.application.domain.entities.SalaryEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SalaryRepository extends ReactiveCrudRepository<SalaryEntity, UUID> {
}
