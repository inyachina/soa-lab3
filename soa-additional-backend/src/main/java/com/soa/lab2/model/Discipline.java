package com.soa.lab2.model;

import lombok.*;
import org.springframework.lang.Nullable;


@Getter
@Builder
@NonNull
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Discipline {
    private int id;

    private String name;
    @Nullable
    private int lectureHours;
    private int selfStudyHours;

}
