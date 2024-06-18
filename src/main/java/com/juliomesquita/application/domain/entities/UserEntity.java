package com.juliomesquita.application.domain.entities;

import jakarta.validation.constraints.Email;
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

@Table(name = "tb_users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity {
    @Id
    @Column(value = "user_id")
    private UUID id;

    @NotBlank
    @Email
    @Max(message = "Email não deve conter mais do que 100 caracteres.", value = 100)
    @Column(value = "user_email")
    private String email;

    @NotBlank
    @NotEmpty
    @Column(value = "user_active")
    private Boolean active;
}
