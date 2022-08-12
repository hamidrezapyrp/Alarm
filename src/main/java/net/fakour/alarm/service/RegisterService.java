package net.fakour.alarm.service;

import net.fakour.alarm.dto.RegisterDto;
import net.fakour.alarm.entity.Register;

import java.util.List;

public interface RegisterService {
    public String addUser(RegisterDto register);
    public List<Register> userList();
}
