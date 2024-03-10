package com.tobeto.bootcamp.business.responses.get.applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetApplicantResponse {

    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String about;
}
