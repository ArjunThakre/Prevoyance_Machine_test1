package com.Employee.controller;


import com.Employee.dto.AuthRequest;
import com.Employee.dto.AuthResponse;
import com.Employee.entity.Employee;
import com.Employee.repository.EmployeeRepository;
import com.Employee.service.AuthService;
import com.Employee.utils.JwtUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        authenticationManager.authenticate(authToken);
        UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtils.generateToken(user);
        return ResponseEntity.ok(new AuthResponse(token));

    }
}


//    @PostMapping("/signup")
//    public ResponseEntity<String> register(@Valid @RequestBody Employee employee){
//        String result = authService.registerEmployee(employee);
//        if (result.contains("Exist")){
//            return ResponseEntity.badRequest().body(result);
//        }
//        return ResponseEntity.ok(result);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password){
//        boolean success=authService.loginEmployee(username, password);
//        if (success){
//            return ResponseEntity.ok("Login Succesfull!");
//        }
//        return ResponseEntity.status(401).body("Invalid Username & Password");
//    }
//}
