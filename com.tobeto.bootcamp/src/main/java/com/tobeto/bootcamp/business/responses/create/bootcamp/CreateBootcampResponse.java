package com.tobeto.bootcamp.business.responses.create.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {
    private int id;
    private int instructorId;
    private int bootcampStateId;
    private String name;
    private LocalDate startData;
    private LocalDate endDate;
}
