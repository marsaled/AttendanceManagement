package marsal.Attendence.Repository;

import marsal.Attendence.model.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity,Long> {
}
