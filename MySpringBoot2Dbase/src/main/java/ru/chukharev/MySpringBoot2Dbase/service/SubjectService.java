package ru.chukharev.MySpringBoot2Dbase.service;

import org.springframework.stereotype.Service;
import ru.chukharev.MySpringBoot2Dbase.entity.Subject;

import java.util.List;

@Service
public interface SubjectService {

    List<Subject> getAllSubjects();

    Subject saveSubject(Subject subject);

    Subject getSubject(int id);

    void deleteSubject(int id);
}
