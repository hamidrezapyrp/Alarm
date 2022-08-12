package net.fakour.alarm.mapper;

import net.fakour.alarm.dto.AlarmDto;
import net.fakour.alarm.dto.RegisterDto;
import net.fakour.alarm.entity.Alarm;
import net.fakour.alarm.entity.Register;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapper {
    public Register toEntityRegister(RegisterDto registerDto){
       Register register = new Register();
       register.setUserName(registerDto.getUserName());
       register.setPassword(registerDto.getPassword());
       return register;
    }
}
