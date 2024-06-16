package com.juliomesquita.application.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("anime")
public class Anime {
    @Id
    private Integer id;

    private String name;
}
