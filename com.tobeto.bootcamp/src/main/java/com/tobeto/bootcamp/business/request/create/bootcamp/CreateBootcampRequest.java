package com.tobeto.bootcamp.business.request.create.bootcamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampRequest {
    private String name;
    private int instructorId;
    private int bootcampStateId;
    private LocalDate startDate;
    private LocalDate endDate;
}
