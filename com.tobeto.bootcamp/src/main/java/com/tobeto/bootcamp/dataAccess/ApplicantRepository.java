package com.tobeto.bootcamp.dataAccess;

import com.tobeto.bootcamp.entities.concretes.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {
  Applicant getById(int id);

// integer id getiriyo
  Applicant getByEmail(String email);

}







