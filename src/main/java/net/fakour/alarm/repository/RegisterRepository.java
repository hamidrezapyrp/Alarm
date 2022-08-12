package net.fakour.alarm.repository;

import net.fakour.alarm.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register,Long> {
    public boolean existsRegisterByUserName(String user);
    public boolean existsRegisterByPassword(String pass);
}
