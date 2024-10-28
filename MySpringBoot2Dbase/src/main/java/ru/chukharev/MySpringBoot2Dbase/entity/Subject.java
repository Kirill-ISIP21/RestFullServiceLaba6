package ru.chukharev.MySpringBoot2Dbase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SUBJECTS")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "subject_name")
    private String subject_name;

    @Column(name = "description")
    private String description;

    @Column(name = "assessment_method")
    private String assessment_method;

    @Column(name = "is_mandatory")
    private Boolean is_mandatory;
}
