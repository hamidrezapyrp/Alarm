package net.fakour.alarm.mapper;

import com.sun.istack.NotNull;
import net.fakour.alarm.dto.TicketDto;
import net.fakour.alarm.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public Ticket toEntityTicket(@NotNull TicketDto ticketdto){
        Ticket ticket = new Ticket();
        ticket.setAlarmId(ticketdto.getAlarmId());
        ticket.setErrormessage(ticketdto.getErrormessage());
        ticket.setErrorType(ticketdto.getErrorType());
        ticket.setLocation(ticketdto.getLocation());
        ticket.setTime(ticketdto.getTime());
        ticket.setId(ticketdto.getId());
        return ticket;
    }
}
