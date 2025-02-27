package com.luve2code.jpahibernatecrud.dao;

import com.luve2code.jpahibernatecrud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save (Student theStudent);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void delete(Integer id);

    int deleteAll();
}
