package com.tobeto.bootcamp.business.abstracts;
import com.tobeto.bootcamp.business.request.create.employee.CreateEmployeeRequest;
import com.tobeto.bootcamp.business.request.update.employee.UpdateEmployeeRequest;
import com.tobeto.bootcamp.business.responses.create.employee.CreateEmployeeResponse;
import com.tobeto.bootcamp.business.responses.get.employee.GetAllEmployeeResponse;
import com.tobeto.bootcamp.business.responses.get.employee.GetEmployeeResponse;
import com.tobeto.bootcamp.business.responses.update.employee.UpdateEmployeeResponse;
import com.tobeto.bootcamp.core.utilities.results.DataResult;
import com.tobeto.bootcamp.core.utilities.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest request);

    DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest request);
    Result delete(int id);

        DataResult<List<GetAllEmployeeResponse>> getAll();
    DataResult<GetEmployeeResponse> getById(int id);
}
