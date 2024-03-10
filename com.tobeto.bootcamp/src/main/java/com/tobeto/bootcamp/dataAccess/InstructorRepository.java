package com.tobeto.bootcamp.dataAccess;

import com.tobeto.bootcamp.entities.concretes.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository <Instructor, Integer> {
    Instructor getById(int id);
    Instructor getByEmail(String email);
}
