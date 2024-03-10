package com.tobeto.bootcamp.entities.concretes;

import com.tobeto.bootcamp.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class User extends BaseEntity<Integer> {

    @Column(name = "userName")
    private String userName;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    @Column(name = "nationalIdentity")
    private String nationalIdentity;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
