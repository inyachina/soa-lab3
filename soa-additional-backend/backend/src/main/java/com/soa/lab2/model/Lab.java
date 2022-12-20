package com.soa.lab2.model;

import lombok.*;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@NonNull
@Data
@Builder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Lab {

    private int id;

    private String name;

    private double x;

    @Nullable
    private double y;

    private LocalDate creationDate;

    private int minimalPoint;

    private float personalQualitiesMaximum;

    private Difficulty difficulty;

    private Discipline discipline;

}
