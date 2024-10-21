package com.skateflow.Skateflow.control;

import com.skateflow.Skateflow.model.AdminLogin;
import com.skateflow.Skateflow.model.LoginRequest;
import com.skateflow.Skateflow.repository.AdminLoginRepository;
import com.skateflow.Skateflow.repository.LoginRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private AdminLoginRepository adminLoginRepository;

    @Autowired
    private LoginRequestRepository loginRequestRepository;

    @GetMapping
    public List<AdminLogin> listarAdmins() {
        return adminLoginRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<AdminLogin> registrarAdmin(@RequestBody AdminLogin admin) {
        AdminLogin novoAdmin = adminLoginRepository.save(admin);
        return ResponseEntity.ok(novoAdmin);
    }

    @PostMapping("/login")
    public ResponseEntity<AdminLogin> loginUsuario(@RequestBody LoginRequest loginRequest) {
        Optional<AdminLogin> admin = loginRequestRepository.findByUsernameAndPassword(
                loginRequest.getUsername(), loginRequest.getPassword()
        );

        if (admin.isPresent()) {
            return ResponseEntity.ok(admin.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    // Métodos de obterAdmin, atualizarAdmin e deletarAdmin continuam aqui
}
