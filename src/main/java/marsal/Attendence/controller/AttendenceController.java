package marsal.Attendence.controller;

import jakarta.persistence.Id;
import marsal.Attendence.model.AtendenceEntity;
import marsal.Attendence.services.AttendenceServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/attendance")
public class AttendenceController {


    private  AttendenceServices attendenceServices;

    public AttendenceController(AttendenceServices attendanceServices) {
        this.attendenceServices = attendanceServices;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<AtendenceEntity>> getAllAttendances() {
        List<AtendenceEntity> attendances = attendenceServices.getAllAttendance();
        return new ResponseEntity<>(attendances, HttpStatus.OK);
    }
    @GetMapping("/attendance/{id}")
    public ResponseEntity<AtendenceEntity> getAttendanceById(@PathVariable Long id) {
        Optional<AtendenceEntity> attendanceOptional = attendenceServices.getAttendanceById(id);

        return attendanceOptional.map(attendance -> new ResponseEntity<>(attendance, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping(path = "/create")
    public ResponseEntity<AtendenceEntity> createAttendence(@RequestBody AtendenceEntity atendenceEntity) {
        AtendenceEntity savedAttendance = attendenceServices.saveAttendance(atendenceEntity);
        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        Optional<AtendenceEntity> attendance = attendenceServices.getAttendanceById(id);
        if (attendance.isPresent()) {
            attendenceServices.deleteAttendanceById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

