package marsal.Attendence.controller;

import marsal.Attendence.model.AdminEntity;
import marsal.Attendence.services.AdminServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/admin")
public class AdminController {
    private AdminServices adminServices;

    public AdminController(AdminServices adminServices) {
        this.adminServices = adminServices;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<AdminEntity>> getAllAdmins() {
        List<AdminEntity> emp = adminServices.getAllAdmins(); // Use the injected instance
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AdminEntity> getEmployeeById(@PathVariable Long id)
    {
        Optional<AdminEntity> emp = adminServices.getAdminById(id);
        return emp.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminEntity adminEntity){
        AdminEntity savedAdmin = adminServices.saveAdmin(adminEntity);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }


    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        Optional<AdminEntity> presentAdmin = adminServices.getAdminById(id);
        if (presentAdmin.isPresent()) {
            adminServices.deleteAdminById(id); // Corrected this line
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
