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

    @PostMapping("/login")
    public String login(@RequestBody AdminLogin adminLogin) {
        AdminLogin existingAdmin = adminLoginRepository.findByUsername(adminLogin.getUsername());
        if (existingAdmin != null && existingAdmin.getPassword().equals(adminLogin.getPassword())) {
            return "Login bem-sucedido"; // Lembre-se de implementar a lógica de autenticação
        }
        return "Credenciais inválidas";
    }

    @GetMapping("/admins")
    public List<AdminLogin> listarAdmins() {
        return adminLoginRepository.findAll();
    }


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
    public ResponseEntity<?>  deletarAdmin(@PathVariable Long id){
        return adminLoginRepository.findById(id)
                .map(admin -> {
                    adminLoginRepository.delete(admin);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


    // Outros métodos conforme necessário (por exemplo, registro, atualização)
}
