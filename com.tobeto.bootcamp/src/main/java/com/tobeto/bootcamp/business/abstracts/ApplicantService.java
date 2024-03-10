package com.tobeto.bootcamp.business.abstracts;

import com.tobeto.bootcamp.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcamp.business.request.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcamp.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcamp.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcamp.business.responses.update.applicant.UpdateApplicantResponse;
import com.tobeto.bootcamp.core.utilities.results.DataResult;
import com.tobeto.bootcamp.core.utilities.results.Result;

import java.util.List;
public interface ApplicantService {
    DataResult<CreateApplicantResponse> add(CreateApplicantRequest request);
    DataResult <UpdateApplicantResponse> update(UpdateApplicantRequest request);

    Result delete(int id);

    DataResult<List<GetAllApplicantResponse>> getAll();
    DataResult<GetApplicantResponse> getById(int id);

}
