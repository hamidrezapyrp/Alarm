package net.fakour.alarm.service.impl;

import net.fakour.alarm.dto.LoginDto;
import net.fakour.alarm.repository.RegisterRepository;
import net.fakour.alarm.service.token.CreateToken;
import net.fakour.alarm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    public static Map<LoginDto,String> listUsers = new HashMap<>();

    private RegisterRepository registerRepository;

    @Autowired
    public LoginServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    @Override
    public String checkLogin(LoginDto loginDto) {
            if (registerRepository.existsRegisterByUserName(loginDto.getUserName())&&registerRepository.existsRegisterByPassword(loginDto.getPassword())){
                listUsers.put(loginDto, CreateToken.generateRandomToken());
                return  "user :"+ loginDto.getUserName() + "\n" + "token: " +listUsers.get(loginDto);
            }else {
                return "Please enter the correct username and password";
            }

    }
}
