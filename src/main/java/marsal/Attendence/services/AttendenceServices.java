package marsal.Attendence.services;
import marsal.Attendence.Repository.AttendenceRepository;
import marsal.Attendence.model.AdminEntity;
import marsal.Attendence.model.AtendenceEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendenceServices {
    private final AttendenceRepository attendenceRepository;

    public AttendenceServices(AttendenceRepository attendenceRepository) {
        this.attendenceRepository = attendenceRepository;
    }

    public List<AtendenceEntity> getAllAttendance(){
        return attendenceRepository.findAll();
    }

    public Optional<AtendenceEntity> getAttendanceById(Long id){
        return attendenceRepository.findById(id);
    }

//insert
    public AtendenceEntity saveAttendance(AtendenceEntity atendenceEntity){
        return attendenceRepository.save(atendenceEntity);
    }
    // UPDATE
    public AtendenceEntity updateAdmin(AtendenceEntity atendenceEntity) {
        return attendenceRepository.save(atendenceEntity);
    }
//delete
    public void deleteAttendanceById(Long id) {
        attendenceRepository.deleteById(id);
    }
}




