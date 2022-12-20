package soa.lab.model;

import lombok.*;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Discipline {
    private int id;
    private String name;
    private int lectureHours;
    private int selfStudyHours;

}
