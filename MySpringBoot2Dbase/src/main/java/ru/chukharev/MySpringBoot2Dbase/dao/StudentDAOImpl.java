package ru.chukharev.MySpringBoot2Dbase.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.chukharev.MySpringBoot2Dbase.entity.Student;

import java.util.List;

@Slf4j
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager em;

    @Override
    public List<Student> getAllStudents() {
        Query q = em.createQuery("from Student");
        List<Student> students = q.getResultList();
        log.info("getAllStudents" + students);
        return students;
    }

    @Override
    public Student saveStudent(Student student) {
        return em.merge(student);
    }

    @Override
    public Student getStudent(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public void deleteStudent(int id) {
        Query q = em.createQuery("delete from Student where id=:studentId");
        q.setParameter("studentId", id);
        q.executeUpdate();
    }

}
