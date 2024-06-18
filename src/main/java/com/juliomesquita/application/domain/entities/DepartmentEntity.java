package com.juliomesquita.application.domain.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table(name = "tb_departments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DepartmentEntity {
    @Id
    @NotBlank
    @Column(value = "department_id")
    private UUID id;

    @NotEmpty
    @Max(message = "Nome não deve conter mais que 200 caracteres.", value = 200)
    @Column(value = "department_name")
    private String name;

}
