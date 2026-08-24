package com.example.student_service.service;

import com.example.student_service.StudentService;
import com.example.student_service.entity.Student;
import com.example.student_service.repository.StudentRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @BeforeAll
    public static void init(){
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public  void initEcachTest(){
        System.out.println("BeforeEach");
    }

    @Test
    void createStudentAndCreateStudentSuccessfully(){

        Student student =new Student();
        student.setId(1L);
        student.setName("Vel");
        student.setEmail("vel@123");
        student.setAge(22);
        Mockito.when(studentRepository.save(student)).thenReturn(student);
        Student addStudent= studentService.createStudent(student);
        System.out.println("It my first unit test");

        Assertions.assertNotNull(addStudent);
        Assertions.assertEquals(student.getId(),addStudent.getId());
        Assertions.assertEquals(student.getName(),addStudent.getName());
        Assertions.assertEquals(student.getAge(),addStudent.getAge());
        Assertions.assertEquals(1L, student.getId());


    }


    //NO return type

    @Test
    public void deleteStudentIsDeleteSuccessfully(){
        Mockito.doNothing().when(studentRepository).deleteById(1L);
        studentService.deleteStudent(1L);
        Mockito.verify(studentRepository,Mockito.times(1)).deleteById(1L);
    }

    //Private Method testing



    @AfterAll
    public static void Destroy(){
        System.out.println("AfterAll");
    }

    @AfterEach
    public void cleanup(){
        System.out.println("AfterEach");
    }
}

