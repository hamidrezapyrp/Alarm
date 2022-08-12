package net.fakour.alarm.controller;

import net.fakour.alarm.dto.LoginDto;
import net.fakour.alarm.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping(value = "/login")
    public String login(@RequestBody LoginDto loginDto){
        return loginService.checkLogin(loginDto);
    }
}
