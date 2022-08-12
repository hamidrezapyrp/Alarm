package net.fakour.alarm.service;

import net.fakour.alarm.dto.TokenDto;
import net.fakour.alarm.entity.Ticket;

import java.util.List;

public interface TicketService {
    public List<Ticket> ticketTrue(TokenDto tokenDto) throws Exception;

    public List<Ticket> ticketFalse(TokenDto tokenDto) throws Exception;

    public List<Ticket> repairManAdsl(TokenDto tokenDto) throws Exception;
    public List<Ticket> repairManBts(TokenDto tokenDto) throws Exception;
    public List<Ticket> repairManBsc(TokenDto tokenDto)throws Exception;

    public List<Ticket> BSCError(TokenDto tokenDto) throws Exception;

    public List<Ticket> ADSLError(TokenDto tokenDto) throws Exception;

    public List<Ticket> BTSError(TokenDto tokenDto) throws Exception;


}
