package com.tobeto.bootcamp.wepapi.controllers;


import com.tobeto.bootcamp.business.abstracts.ApplicantService;
import com.tobeto.bootcamp.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcamp.business.request.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcamp.core.utilities.results.DataResult;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantsController extends BaseController{
    private ApplicantService applicantService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateApplicantRequest request) {
        return handleDataResult(applicantService.add(request));
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody UpdateApplicantRequest request) {
        return handleDataResult(applicantService.update(request));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        this.applicantService.delete(id);
        return handleResult(applicantService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return handleDataResult(applicantService.getAll());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(applicantService.getById(id));
    }
}
