package com.tobeto.bootcamp.business.responses.create.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeResponse {
    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
}
