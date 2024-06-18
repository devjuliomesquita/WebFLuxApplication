package com.juliomesquita.application.domain.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table(name = "tb_employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeEntity {
    @Id
    @NotBlank
    @Column(value = "employee_id")
    private UUID id;

    @NotEmpty
    @Max(message = "Nome não deve conter mais que 200 caracteres.", value = 200)
    @Column(value = "employee_name")
    private String name;

    @PositiveOrZero
    @Column(value = "employee_age")
    private Integer age;

    @Column(value = "employee_user_id")
    private UUID userId;

    @Column(value = "employee_department_id")
    private UUID departmentId;

    @Column(value = "employee_salary_id")
    private UUID salaryId;
}
