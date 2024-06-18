package com.juliomesquita.application.domain.entities;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.util.UUID;

@Table(name = "tb_salaries")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SalaryEntity {
    @Id
    @Column(value = "salary_id")
    private UUID id;

    @NotEmpty
    @Max(message = "Cargo não deve conter mais que 200 caracteres.", value = 200)
    @Column(value = "salary_rule")
    private String rule;

    @PositiveOrZero
    @Column(value = "salary_value")
    private BigDecimal salaryValue;

}
