package net.fakour.alarm.service.impl;

import net.fakour.alarm.dto.AlarmDto;
import net.fakour.alarm.entity.Alarm;
import net.fakour.alarm.mapper.AlarmMapper;
import net.fakour.alarm.repository.AlarmRepository;
import net.fakour.alarm.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;


@Service
public class AlarmServiceImpl implements AlarmService {

    private Integer id = 1;

    private AlarmMapper alarmMapper;

    private AlarmRepository alarmRepository;


    private static Logger logger = LoggerFactory.getLogger(AlarmServiceImpl.class);
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static String[] type_error = {"BTS", "BSC", "ADSL"};

    public static String[] error_message = {"A problem with the mast", "A fire in the mast", "A problem in the mast board"};

    public static String[] location = {"tehran", "zanjan", "mazandaran", "tabriz", "karaj", "rey", "shiraz"};


    @Autowired
    public AlarmServiceImpl(AlarmMapper alarmMapper, AlarmRepository alarmRepository) {
        this.alarmMapper = alarmMapper;
        this.alarmRepository = alarmRepository;
    }


    @Override
    public List<Alarm> listAlarm() {
        return alarmRepository.findAll();
    }


    @Override
    @Scheduled(fixedDelay = 60000)
    public void createErrors() {
        AlarmDto alarm = new AlarmDto();
        Random rand = new Random();
        int types = rand.nextInt(type_error.length);
        int message = rand.nextInt(error_message.length);
        int city = rand.nextInt(location.length);
        alarm.setAlarmId(id);
        alarm.setErrormessage(error_message[message]);
        alarm.setTime(dateTimeFormatter.format(LocalDateTime.now()));
        alarm.setErrorType(type_error[types]);
        alarm.setLocation(location[city]);
        alarmRepository.save(alarmMapper.toEntityAlarm(alarm));
        id++;
    }


}
