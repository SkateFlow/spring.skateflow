package com.skateflow.Skateflow.control;

import com.skateflow.Skateflow.model.AdminLogin;
import com.skateflow.Skateflow.repository.AdminLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private AdminLoginRepository adminLoginRepository;


    @GetMapping
    public List<AdminLogin> listarAdmins() {
        return adminLoginRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<AdminLogin> registrarAdmin(@RequestBody AdminLogin admin) {
        AdminLogin novoAdmin = adminLoginRepository.save(admin);
        return ResponseEntity.ok(novoAdmin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminLogin> obterAdmin(@PathVariable Long id) {
        return adminLoginRepository.findById(id)
                .map(admin -> ResponseEntity.ok().body(admin))
                .orElse(ResponseEntity.notFound().build());
    }






    @PutMapping("/{id}")
    public ResponseEntity<AdminLogin> atualizarAdmin(@PathVariable Long id,@RequestBody AdminLogin adminLoginDetails) {
        return adminLoginRepository.findById(id)
                .map(adminLogin -> {
                    adminLogin.setUsername(adminLoginDetails.getUsername());
                    adminLogin.setPassword(adminLoginDetails.getPassword());
                    AdminLogin atualizado = adminLoginRepository.save(adminLogin);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }
   // Delete


    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deletarAdmin(@PathVariable Long id){
        return adminLoginRepository.findById(id)
                .map(admin -> {
                    adminLoginRepository.delete(admin);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


    // Outros métodos conforme necessário (por exemplo, registro, atualização)
}
