package net.fakour.alarm.repository;

import net.fakour.alarm.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmRepository extends JpaRepository<Alarm,Long> {
    @Override
    public List<Alarm> findAll();
}
