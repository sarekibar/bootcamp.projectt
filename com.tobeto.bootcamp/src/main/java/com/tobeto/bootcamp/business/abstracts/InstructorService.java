package com.tobeto.bootcamp.business.abstracts;

import com.tobeto.bootcamp.business.request.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcamp.business.request.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcamp.business.responses.create.instructor.CreateInstructorResponse;
import com.tobeto.bootcamp.business.responses.get.insructor.GetAllInstructorResponse;
import com.tobeto.bootcamp.business.responses.get.insructor.GetInstructorResponse;
import com.tobeto.bootcamp.core.utilities.results.DataResult;
import com.tobeto.bootcamp.core.utilities.results.Result;

import java.util.List;

public interface InstructorService {
   DataResult<CreateInstructorResponse> add(CreateInstructorRequest request);

   Result delete(int id);
   DataResult<List<GetAllInstructorResponse>> getAll();
   DataResult<GetInstructorResponse> getById(int id);

   DataResult<?> update(UpdateInstructorRequest request);
}

