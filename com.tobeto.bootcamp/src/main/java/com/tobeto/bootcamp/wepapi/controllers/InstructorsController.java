package com.tobeto.bootcamp.wepapi.controllers;


import com.tobeto.bootcamp.business.abstracts.InstructorService;
import com.tobeto.bootcamp.business.request.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcamp.business.request.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcamp.business.responses.create.instructor.CreateInstructorResponse;
import com.tobeto.bootcamp.core.utilities.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorsController extends BaseController {
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CreateInstructorRequest request) {
        return handleDataResult(instructorService.add(request));
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody UpdateInstructorRequest request) {
        return handleDataResult(instructorService.update(request));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        this.instructorService.delete(id);
        return handleResult(instructorService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return handleDataResult(instructorService.getAll());
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return handleDataResult(instructorService.getById(id));
    }
}
