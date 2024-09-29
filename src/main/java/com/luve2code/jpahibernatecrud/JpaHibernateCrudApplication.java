package com.luve2code.jpahibernatecrud;

import com.luve2code.jpahibernatecrud.dao.StudentDAO;
import com.luve2code.jpahibernatecrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaHibernateCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateCrudApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner->{
//            createStudent(studentDAO);
//            creatMultiStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastNAme(studentDAO);
            updateStudent(studentDAO);

        };
    }

    private void createStudent(StudentDAO studentDAO) {
        //create student object
        System.out.println("Creating new student object...");
        Student temp = new Student("Haneen","Mohamed","haneen.m.elfeky@gmail.com");

        //save the student object
        System.out.println("Saving student");
        studentDAO.save(temp);

        //display id of the saved student
        System.out.println("Student Saved with id "+temp.getId());
    }


    private void creatMultiStudents(StudentDAO studentDAO) {
        //create students object
        System.out.println("Creating new students object...");
        Student temp = new Student("Haneen","Mohamed","haneen.m.elfeky@gmail.com");
        Student temp1 = new Student("Mohamed","Ahmed","mohamedelfeky@gmail.com");
        Student temp2 = new Student("Asmaa","Ali","asmaa.ali@gmail.com");

        //save the student object
        System.out.println("Save students");
        studentDAO.save(temp);
        studentDAO.save(temp1);
        studentDAO.save(temp2);
    }


    private void readStudent(StudentDAO studentDAO) {
        //create student object
        System.out.println("Creating new student object...");
        Student temp = new Student("Gana","Yazed","GanaYZ@gmail.com");
        //save the student object
        System.out.println("Save student");
        studentDAO.save(temp);

        //display id for saved student
        int id = temp.getId();
        System.out.println("Student is Saved with ID : "+id);
        Student student=studentDAO.findById(id);

        System.out.println("Found Student "+student);

    }


    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student:students){
            System.out.println(student);
        }
    }


    private void queryForStudentsByLastNAme(StudentDAO studentDAO) {
        // get list of students
        List<Student> students = studentDAO.findByLastName("Mohamed");

        // display list of students
        for (Student student : students){
            System.out.println(student);
        }
    }


    private void updateStudent(StudentDAO studentDAO) {
     int id=1;
     Student student = studentDAO.findById(id);
     student.setFirstName("Hon");
     student.setEmail("HON@gmail.com");
     studentDAO.update(student);
     System.out.println("Student Updated to : "+student);
    }
}
