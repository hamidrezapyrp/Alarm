package net.fakour.alarm.service.impl;

import net.fakour.alarm.dto.TicketDto;
import net.fakour.alarm.dto.TokenDto;
import net.fakour.alarm.entity.Alarm;
import net.fakour.alarm.entity.Ticket;
import net.fakour.alarm.mapper.TicketMapper;
import net.fakour.alarm.repository.AlarmRepository;
import net.fakour.alarm.repository.TicketRepository;
import net.fakour.alarm.service.TicketService;
import net.fakour.alarm.thread.RepairmanServiceADSL;
import net.fakour.alarm.thread.RepairmanServiceBSC;
import net.fakour.alarm.thread.RepairmanServiceBTS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private  Integer  id = 1 ;
    private final TicketRepository ticketRepository;
    private final AlarmRepository alarmRepository;

    private TicketMapper ticketMapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, AlarmRepository alarmRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.alarmRepository = alarmRepository;
        this.ticketMapper = ticketMapper;
    }

    @Scheduled(fixedRate = 60000)
    public void insertTicket() {
        TicketDto ticket = new TicketDto();
        for (Alarm in : alarmRepository.findAll()) {
            if (in.getAlarmId() > ticketRepository.count()) {
                ticket.setAlarmId(in.getAlarmId());
                ticket.setLocation(in.getLocation());
                ticket.setErrorType(in.getErrorType());
                ticket.setErrormessage(in.getErrormessage());
                ticket.setTime(in.getTime());
                ticket.setId(id);
                id++;
                System.out.println(ticket.getErrormessage() + " " + ticket.getErrorType() +  " " +ticket.getLocation() + " " + ticket.getTime());
                ticketRepository.save(ticketMapper.toEntityTicket(ticket));
            }
        }
    }

    @Async
    @Scheduled(fixedRate = 6000)
    public void repairADSL() {
        Thread ta = new Thread(new RepairmanServiceADSL(ticketRepository));
        ta.start();

    }
    @Async
    @Scheduled(fixedRate = 6000)
    public void repairBSC()  {
        Thread tb = new Thread(new RepairmanServiceBSC(ticketRepository));
        tb.start();
    }
    @Async
    @Scheduled(fixedRate = 6000)
    public void repairBTS() {
        Thread tc = new Thread(new RepairmanServiceBTS(ticketRepository));
        tc.start();
    }

    @Override
    public List<Ticket> ticketTrue(TokenDto tokenDto) throws Exception {
        if (LoginServiceImpl.listUsers.containsValue(tokenDto.getToken())) {
            return ticketRepository.findAllByStatus(true);
        }else {
            throw new Exception("pleas enter your token");
        }

    }

    @Override
    public List<Ticket> ticketFalse(TokenDto tokenDto) throws Exception {
        if (LoginServiceImpl.listUsers.containsValue(tokenDto.getToken())) {
            return ticketRepository.findAllByStatus(false);
        }else {
            throw new Exception("pleas enter your token");
        }

    }

    @Override
    public List<Ticket> repairManAdsl(TokenDto tokenDto) throws Exception {
        if (LoginServiceImpl.listUsers.containsValue(tokenDto.getToken())) {
            return ticketRepository.findAllByStatusIsTrueAndErrorType("ADSL");
        }else {
            throw new Exception("pleas enter your token");
        }
    }

    @Override
    public List<Ticket> repairManBts(TokenDto tokenDto) throws Exception {
        if (LoginServiceImpl.listUsers.containsValue(tokenDto.getToken())){
            return  ticketRepository.findAllByStatusIsTrueAndErrorType("BTS");
        }else {
            throw new Exception("pleas enter your token");
        }

    }

    @Override
    public List<Ticket> repairManBsc(TokenDto tokenDto) throws Exception {
        if (LoginServiceImpl.listUsers.containsValue(tokenDto.getToken())){
            return  ticketRepository.findAllByStatusIsTrueAndErrorType("BSC");
        }else {
            throw new Exception("pleas enter your token");
        }

    }


    @Override
    public List<Ticket> BSCError(TokenDto tokenDto) throws Exception {
        if (LoginServiceImpl.listUsers.containsValue(tokenDto.getToken())){
            return ticketRepository.findAllByErrorType("BSC");
        }else {
            throw new Exception("pleas enter your token");
        }

    }

    @Override
    public List<Ticket> ADSLError(TokenDto tokenDto) throws Exception {
        if (LoginServiceImpl.listUsers.containsValue(tokenDto.getToken())){
            return ticketRepository.findAllByErrorType("ADSL");
        }else {
            throw new Exception("pleas enter your token");
        }

    }

    @Override
    public List<Ticket> BTSError(TokenDto tokenDto) throws Exception {
        if (LoginServiceImpl.listUsers.containsValue(tokenDto.getToken())){
            return ticketRepository.findAllByErrorType("BTS");
        }else {
            throw new Exception("pleas enter your token");
        }

    }
}
