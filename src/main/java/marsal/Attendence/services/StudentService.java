package marsal.Attendence.services;

import marsal.Attendence.Repository.StudentRepository;
import marsal.Attendence.model.AdminEntity;
import marsal.Attendence.model.StudentsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentsEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<StudentsEntity> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
//insert
    public StudentsEntity saveStudent(StudentsEntity studentsEntity){
        return studentRepository.save(studentsEntity);
    }
    // UPDATE
    public StudentsEntity update(StudentsEntity studentsEntity) {
        return studentRepository.save(studentsEntity);
    }
//delete
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}

