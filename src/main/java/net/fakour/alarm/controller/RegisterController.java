package net.fakour.alarm.controller;

import net.fakour.alarm.dto.RegisterDto;
import net.fakour.alarm.entity.Register;
import net.fakour.alarm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @PostMapping(value = "/register")
    public String register(@RequestBody RegisterDto register) throws Exception{
        return registerService.addUser(register);
    }

}
