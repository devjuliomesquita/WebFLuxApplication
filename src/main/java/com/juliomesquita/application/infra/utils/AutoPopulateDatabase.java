package com.juliomesquita.application.infra.utils;

import com.github.javafaker.Faker;
import com.juliomesquita.application.domain.entities.EmployeeEntity;
import com.juliomesquita.application.domain.entities.UserEntity;
import com.juliomesquita.application.infra.repositories.DepartmentRepository;
import com.juliomesquita.application.infra.repositories.EmployeeRepository;
import com.juliomesquita.application.infra.repositories.SalaryRepository;
import com.juliomesquita.application.infra.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class AutoPopulateDatabase implements CommandLineRunner {
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final SalaryRepository salaryRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
//        Criando usuários e Colaboradores
        List<UserEntity> userEntities = new ArrayList<>();
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            userEntities.add(UserEntity.builder()
                    .email(faker.internet().emailAddress())
                    .active(i % 3 != 0)
                    .build());
            employeeEntities.add(EmployeeEntity.builder()
                    .name(faker.name().fullName())
                    .age(faker.number().numberBetween(16, 100))
                    .build());
        }
//        Mono<UserEntity> save = this.userRepository.save(userEntities.get(0));
//
//        employeeEntities.forEach(this.employeeRepository::save);
        this.userRepository.saveAll(userEntities).subscribe();
        this.employeeRepository.saveAll(employeeEntities).subscribe();
        log.info("Usuários e Colaboradores criados.");
    }

}
