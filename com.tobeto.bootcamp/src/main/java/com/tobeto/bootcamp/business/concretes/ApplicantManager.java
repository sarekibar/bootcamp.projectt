package com.tobeto.bootcamp.business.concretes;

import com.tobeto.bootcamp.business.abstracts.ApplicantService;
import com.tobeto.bootcamp.business.request.create.applicant.CreateApplicantRequest;
import com.tobeto.bootcamp.business.request.update.applicant.UpdateApplicantRequest;
import com.tobeto.bootcamp.business.responses.create.applicant.CreateApplicantResponse;
import com.tobeto.bootcamp.business.responses.get.applicant.GetAllApplicantResponse;
import com.tobeto.bootcamp.business.responses.get.applicant.GetApplicantResponse;
import com.tobeto.bootcamp.business.responses.update.applicant.UpdateApplicantResponse;
import com.tobeto.bootcamp.core.aspects.logging.Loggable;
import com.tobeto.bootcamp.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcamp.core.utilities.results.DataResult;
import com.tobeto.bootcamp.core.utilities.results.Result;
import com.tobeto.bootcamp.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcamp.core.utilities.results.SuccessResult;
import com.tobeto.bootcamp.dataAccess.ApplicantRepository;
import com.tobeto.bootcamp.entities.concretes.Applicant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

    private ModelMapperService modelMapperService;

    private ApplicantRepository applicantRepository;


    @Override
    public DataResult<CreateApplicantResponse> add(CreateApplicantRequest request) {

        Applicant applicant = modelMapperService.forRequest().map(request, Applicant.class);
        applicantRepository.save(applicant);
        CreateApplicantResponse response = modelMapperService.forResponse().map(applicant, CreateApplicantResponse.class);
        return new SuccessDataResult<CreateApplicantResponse>(response, "Aday eklendi")
    }

    @Override
    public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest request) {
        Applicant applicant = applicantRepository.findById(request.getId()).orElseThrow();
        Applicant updatedApplicant = modelMapperService.forRequest().map(request, Applicant.class);

        applicant.setFirstName(updatedApplicant.getFirstName() != null ? updatedApplicant.getFirstName() : applicant.getFirstName());
        applicant.setLastName(updatedApplicant.getLastName() != null ? updatedApplicant.getLastName() : applicant.getLastName());
        applicant.setAbout(updatedApplicant.getAbout() != null ? updatedApplicant.getAbout() : applicant.getAbout());
        applicant.setEmail(updatedApplicant.getEmail() != null ? updatedApplicant.getEmail() : applicant.getEmail());
        applicant.setUserName(updatedApplicant.getUserName() != null ? updatedApplicant.getUserName() : applicant.getUserName());
        applicant.setNationalIdentity(updatedApplicant.getNationalIdentity() != null ? updatedApplicant.getNationalIdentity() : applicant.getNationalIdentity());
        applicant.setDateOfBirth((updatedApplicant.getDateOfBirth() != null ? updatedApplicant.getDateOfBirth() : applicant.getDateOfBirth()));

        applicantRepository.save(applicant);

        UpdateApplicantResponse response = modelMapperService.forResponse().map(applicant, UpdateApplicantResponse.class);
        return new SuccessDataResult<UpdateApplicantResponse>(response, "getirildi")
    }

    @Override
    public Result delete(int id) {
        Applicant applicant = applicantRepository.findById(id).orElseThrow();
        applicantRepository.delete(applicant);
        return new SuccessResult("aday silindi")
    }

    @Override
    @Loggable
    public DataResult<List<GetAllApplicantResponse>> getAll() {
        List<Applicant> applicants = applicantRepository.findAll();
        List<GetAllApplicantResponse> applicantResponses = applicants.stream().map(applicant -> modelMapperService.forResponse()
                .map(applicant, GetAllApplicantResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllApplicantResponse>>(applicantResponses, "tum adaylar getirildi");
    }

    @Override
    public DataResult<GetApplicantResponse getById(int id) {
        Applicant applicant = applicantRepository.getById(id);
        GetApplicantResponse response = modelMapperService.forResponse().map(applicant, GetApplicantResponse.class);
        return new SuccessDataResult<GetApplicantResponse>(response, "aday getirildi");
    }
}
