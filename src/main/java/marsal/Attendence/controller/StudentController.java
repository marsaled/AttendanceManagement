package marsal.Attendence.controller;

import marsal.Attendence.model.StudentsEntity;
import marsal.Attendence.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path= "/all")
    public ResponseEntity<List<StudentsEntity>> getAllStudents() {
        List<StudentsEntity> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @GetMapping(path= "/{id}")
    public ResponseEntity<StudentsEntity> getStudentById(@PathVariable Long id) {
        Optional<StudentsEntity> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
    }


    @PostMapping(path= "/create")
    public ResponseEntity<StudentsEntity> createStudent( @RequestBody StudentsEntity studentsEntity) {
        StudentsEntity savedStudent = studentService.saveStudent(studentsEntity);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        Optional<StudentsEntity> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            studentService.deleteStudentById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

