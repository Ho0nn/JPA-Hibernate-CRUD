package com.luve2code.jpahibernatecrud.dao;

import com.luve2code.jpahibernatecrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;


    // inject entity manager using constructor injection
    @Autowired //optional when have one constructor
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // implement save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("From Student order by lastName ", Student.class);

        // return query result
        return studentTypedQuery.getResultList();

    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery(
                "From Student where lastName=:data", Student.class);
        studentTypedQuery.setParameter("data", lastName);
        return studentTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
}
