package com.luve2code.jpahibernatecrud;

import com.luve2code.jpahibernatecrud.dao.StudentDAO;
import com.luve2code.jpahibernatecrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaHibernateCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateCrudApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner->{
            creatStudents(studentDAO);
        };
    }

    private void creatStudents(StudentDAO studentDAO) {
        //create student object
        System.out.println("Creating new student object...");
        Student temp = new Student("Haneen","Mohamed","haneen.m.elfeky@gmail.com");

        //save the student object
        System.out.println("Saving student");
        studentDAO.save(temp);

        //display id of the saved student
        System.out.println("Student Saved with id "+temp.getId());
    }
}
