package com.tobeto.bootcamp.business.concretes;

import com.tobeto.bootcamp.business.abstracts.InstructorService;
import com.tobeto.bootcamp.business.request.create.instructor.CreateInstructorRequest;
import com.tobeto.bootcamp.business.request.update.instructor.UpdateInstructorRequest;
import com.tobeto.bootcamp.business.responses.create.instructor.CreateInstructorResponse;
import com.tobeto.bootcamp.business.responses.get.insructor.GetAllInstructorResponse;
import com.tobeto.bootcamp.business.responses.get.insructor.GetInstructorResponse;
import com.tobeto.bootcamp.business.responses.update.instructor.UpdateInstructorResponse;
import com.tobeto.bootcamp.core.utilities.mapping.ModelMapperService;
import com.tobeto.bootcamp.core.utilities.results.DataResult;
import com.tobeto.bootcamp.core.utilities.results.Result;
import com.tobeto.bootcamp.core.utilities.results.SuccessDataResult;
import com.tobeto.bootcamp.core.utilities.results.SuccessResult;
import com.tobeto.bootcamp.dataAccess.InstructorRepository;
import com.tobeto.bootcamp.entities.concretes.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Data
@NoArgsConstructor
public class InstructorManager implements InstructorService {
    private ModelMapperService modelMapperService;
    private InstructorRepository instructorRepository;

    @Override
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest request) {

        Instructor instructor = modelMapperService.forRequest().map(request, Instructor.class);
        instructorRepository.save(instructor);
        CreateInstructorResponse response = modelMapperService.forRequest().map(instructor, CreateInstructorResponse.class);
        return new SuccessDataResult<CreateInstructorResponse>(response, "Eğitmen başarıyla eklendi");
    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest request) {

        Instructor instructor = instructorRepository.findById(request.getId()).orElseThrow();
        Instructor updatedInstructor = modelMapperService.forRequest().map(request, Instructor.class);

        instructor.setFirstName(updatedInstructor.getFirstName() != null ? updatedInstructor.getFirstName() : instructor.getFirstName());
        instructor.setLastName(updatedInstructor.getLastName() != null ? updatedInstructor.getLastName() : instructor.getLastName());
        instructor.setCompanyName(updatedInstructor.getCompanyName() != null ? updatedInstructor.getCompanyName() : instructor.getCompanyName());
        instructor.setEmail(updatedInstructor.getEmail() != null ? updatedInstructor.getEmail() : instructor.getEmail());
        instructor.setUserName(updatedInstructor.getUserName() != null ? updatedInstructor.getUserName() : instructor.getUserName());
        instructor.setNationalIdentity(updatedInstructor.getNationalIdentity() != null ? updatedInstructor.getNationalIdentity() : instructor.getNationalIdentity());
        instructor.setDateOfBirth(updatedInstructor.getDateOfBirth() != null ? updatedInstructor.getDateOfBirth() : instructor.getDateOfBirth());

        instructorRepository.save(instructor);
        UpdateInstructorResponse response = modelMapperService.forResponse().map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<UpdateInstructorResponse>(response, "Eğitmen güncellendi");
    }

   @Override
    public Result delete(int id){
        Instructor instructor = instructorRepository.findById(id).orElseThrow();
        instructorRepository.delete(instructor);
        return new SuccessResult("Eğitmen silindi");
    }

    @Override
    public DataResult<List<GetAllInstructorResponse>> getAll() {
        List<Instructor> instructors = instructorRepository.findAll();
        List<GetAllInstructorResponse> instructorResponses = instructors.stream().map(instructor -> modelMapperService.forResponse()
                .map(instructor, GetAllInstructorResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllInstructorResponse>>(instructorResponses, "Tüm eğitmenler getirildi");
    }

    @Override
    public DataResult<GetInstructorResponse> getById(int id) {
        Instructor instructor = instructorRepository.getById(id);
        GetInstructorResponse response = modelMapperService.forResponse().map(instructor, GetInstructorResponse.class);
        return new SuccessDataResult<GetInstructorResponse>(response, "Eğitmen getirildi");
    }
}
