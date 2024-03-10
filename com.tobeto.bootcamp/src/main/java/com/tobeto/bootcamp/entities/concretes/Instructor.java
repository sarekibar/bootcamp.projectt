package com.tobeto.bootcamp.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "instructors")
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Instructor extends User {
    @Column(name = "companyName")
    private String companyName;
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.DETACH)
    private List<Bootcamp> bootcamps;
}
