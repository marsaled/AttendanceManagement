package marsal.Attendence.Repository;

import marsal.Attendence.model.AtendenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendenceRepository extends JpaRepository<AtendenceEntity, Long> {
    List<AtendenceEntity> findByStudentId(Long studentId);
}
