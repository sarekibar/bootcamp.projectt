package com.tobeto.bootcamp.entities.concretes;

import com.tobeto.bootcamp.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "applicationStates")
@EqualsAndHashCode(callSuper = true)

public class ApplicationState extends BaseEntity<Integer> {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "applicationState", cascade = CascadeType.REMOVE)
    private List<Application> applications;

}
