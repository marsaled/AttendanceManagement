package marsal.Attendence.services;

import marsal.Attendence.Repository.AdminRepository;
import marsal.Attendence.model.AdminEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServices {

    private final AdminRepository adminRepository;

    public AdminServices(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<AdminEntity> getAllAdmins(){
        return adminRepository.findAll();
    }

    public Optional<AdminEntity> getAdminById(Long id){
        return adminRepository.findById(id);
    }

    // INSERT
    public AdminEntity saveAdmin(AdminEntity adminEntity){
        return adminRepository.save(adminEntity);
    }
    // UPDATE
    public AdminEntity updateAdmin(AdminEntity adminEntity) {
        return adminRepository.save(adminEntity);
    }
//delete
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }
}
