package ru.chukharev.MySpringBoot2Dbase.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.chukharev.MySpringBoot2Dbase.entity.Subject;

import java.util.List;

@Slf4j
@Repository
public class SubjectDAOImpl implements SubjectDAO {

    @Autowired
    private EntityManager em;

    @Override
    public List<Subject> getAllSubjects() {
        Query q = em.createQuery("from Subject");
        List<Subject> subjects = q.getResultList();
        log.info("getAllSubjects " + subjects);
        return subjects;
    }

    @Override
    public Subject saveSubject(Subject subject) {
        return em.merge(subject);
    }

    @Override
    public Subject getSubject(int id) {
        return em.find(Subject.class, id);
    }

    @Override
    public void deleteSubject(int id) {
        Query q = em.createQuery("delete from Subject where id=:SubjectId");
        q.setParameter("SubjectId", id);
        q.executeUpdate();
    }
}
