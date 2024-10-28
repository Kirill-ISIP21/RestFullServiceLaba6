package ru.chukharev.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.chukharev.MySpringBoot2Dbase.entity.Subject;
import ru.chukharev.MySpringBoot2Dbase.service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> allStudents() {
        List<Subject> allSubjects = subjectService.getAllSubjects();
        return new ResponseEntity<>(allSubjects, HttpStatus.OK);
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<Subject> getStudent(@PathVariable("id") int id) {
        return new ResponseEntity<>(subjectService.getSubject(id), HttpStatus.OK);
    }

    @PostMapping("/subjects")
    public ResponseEntity<Subject> saveStudent(@RequestBody Subject subject) {
        subjectService.saveSubject(subject);
        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }

    @PutMapping("/subjects")
    public ResponseEntity<Subject> updateStudent(@RequestBody Subject subject) {
        subjectService.saveSubject(subject);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @DeleteMapping("/subjects/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        subjectService.deleteSubject(id);
    }
}
