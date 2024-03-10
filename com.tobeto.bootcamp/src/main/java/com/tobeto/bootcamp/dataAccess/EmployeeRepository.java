package com.tobeto.bootcamp.dataAccess;

import com.tobeto.bootcamp.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee getById(int id);
    Employee getByEmail(String email);
}

