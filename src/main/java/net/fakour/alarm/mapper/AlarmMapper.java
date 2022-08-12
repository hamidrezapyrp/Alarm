package net.fakour.alarm.mapper;

import net.fakour.alarm.dto.AlarmDto;
import net.fakour.alarm.entity.Alarm;

import org.springframework.stereotype.Component;

@Component
public class AlarmMapper {
    public Alarm toEntityAlarm(AlarmDto alarmDto){
        Alarm alarm = new Alarm();
        alarm.setAlarmId(alarmDto.getAlarmId());
        alarm.setErrormessage(alarmDto.getErrormessage());
        alarm.setErrorType(alarmDto.getErrorType());
        alarm.setLocation(alarmDto.getLocation());
        alarm.setTime(alarmDto.getTime());
        return alarm;
    }
}
