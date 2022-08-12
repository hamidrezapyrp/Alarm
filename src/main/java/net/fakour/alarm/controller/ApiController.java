package net.fakour.alarm.controller;


import net.fakour.alarm.dto.TokenDto;
import net.fakour.alarm.entity.Ticket;
import net.fakour.alarm.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    private final TicketService ticketService;

    @Autowired
    public ApiController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/trueList")
    public List<Ticket> trueList(@RequestBody TokenDto tokenDto) throws Exception {
        return ticketService.ticketTrue(tokenDto);
    }

    @PostMapping("/BTS")
    public List<Ticket> BTS(@RequestBody TokenDto tokenDto) throws Exception {
        return ticketService.BTSError(tokenDto);
    }

    @PostMapping("/ADSL")
    public List<Ticket> ADSL(@RequestBody TokenDto tokenDto)throws Exception {
        return ticketService.ADSLError(tokenDto);
    }

    @PostMapping("/BSC")
    public List<Ticket> BSC(@RequestBody TokenDto tokenDto) throws Exception {
        return ticketService.BSCError(tokenDto);
    }

    @PostMapping("/RepairManAdsl")
    public List<Ticket> repairManAdsl(@RequestBody TokenDto tokenDto) throws Exception {
        return ticketService.repairManAdsl(tokenDto);
    }

    @PostMapping("/RepairManBts")
    public List<Ticket> repairManBts(@RequestBody TokenDto tokenDto) throws Exception {
        return ticketService.repairManBts(tokenDto);
    }

    @PostMapping("/RepairManBsc")
    public List<Ticket> repairManBsc(@RequestBody TokenDto tokenDto) throws Exception {
        return ticketService.repairManBsc(tokenDto);
    }

    @PostMapping("/falseList")
    public List<Ticket> falseList(@RequestBody TokenDto tokenDto) throws Exception {
        return ticketService.ticketFalse(tokenDto);
    }


}
