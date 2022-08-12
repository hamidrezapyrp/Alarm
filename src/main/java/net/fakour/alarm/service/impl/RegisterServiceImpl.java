package net.fakour.alarm.service.impl;

import net.fakour.alarm.dto.RegisterDto;
import net.fakour.alarm.entity.Register;
import net.fakour.alarm.mapper.RegisterMapper;
import net.fakour.alarm.repository.RegisterRepository;
import net.fakour.alarm.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    private RegisterMapper registerMapper;

    private RegisterRepository registerRepository;

    @Autowired
    public RegisterServiceImpl(RegisterMapper registerMapper, RegisterRepository registerRepository) {
        this.registerMapper = registerMapper;
        this.registerRepository = registerRepository;
    }

    @Override
    public String addUser(RegisterDto register) {
        if (registerRepository.existsRegisterByUserName(register.getUserName())){
            return "The user is semi-duplicated";
        } else if (register.getPassword().length() > 8) {
            registerRepository.save(registerMapper.toEntityRegister(register));
            return "username:" +" " + register.getUserName() + "\n" + "password:" + " " + register.getPassword() + "\n" + "Registration is done"    ;
        }else {
           return"Please enter the correct password, more than 8 characters";
        }
    }

    @Override
    public List<Register> userList() {
        return registerRepository.findAll();
    }
}
