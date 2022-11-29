package com.example.ControllerProtection.auth.controllers;

import com.example.ControllerProtection.auth.entities.*;
import com.example.ControllerProtection.auth.services.LoginService;
import com.example.ControllerProtection.auth.services.PasswordService;
import com.example.ControllerProtection.auth.services.SignupService;
import com.example.ControllerProtection.entities.Role;
import com.example.ControllerProtection.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private PasswordService passwordService;
    @Autowired
    private SignupService signupService;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupDTO signupDTO) throws Exception {
        signupService.signup(signupDTO);
    }

    @PostMapping("/signup/activation")
    public void activate(@RequestBody SignupActivationDTO signupActivationDTO) throws Exception {
        signupService.activate(signupActivationDTO);
    }

    @PostMapping("/login")
    public LoginRTO login(@RequestBody LoginDTO loginDTO) throws Exception {
        LoginRTO loginRTO = loginService.login(loginDTO);
        if (loginDTO == null) throw new Exception("Cannot login");
        return loginRTO;
    }

    @PostMapping("/password/request")
    public void request(@RequestBody RequestPasswordDTO requestPasswordDTO) throws Exception {
        passwordService.request(requestPasswordDTO);
    }

    @PostMapping("/password/restore")
    public void restore(@RequestBody RestorePasswordDTO restorePasswordDTO) throws Exception {
        passwordService.restore(restorePasswordDTO);
    }

    @PostMapping("/roles") //for populate the role's table, else i can't create the user
    public Role createRoles(@RequestBody Role role){
        return roleRepository.save(role);
    }
}
