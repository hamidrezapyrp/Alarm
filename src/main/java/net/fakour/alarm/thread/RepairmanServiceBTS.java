package net.fakour.alarm.thread;

import net.fakour.alarm.repository.AlarmRepository;
import net.fakour.alarm.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RepairmanServiceBTS implements Runnable {


    private TicketRepository ticketRepository;

    private Integer j = 1;


    @Autowired
    public RepairmanServiceBTS(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void run() {
        for (int i = 0; i < ticketRepository.findAll().size(); i++) {
            if (ticketRepository.findAll().get(i).getId() >= j) {
                if (ticketRepository.findAll().get(i).getErrorType().equals("BTS")) {
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticketRepository.update(ticketRepository.findAll().get(i).getId(), true);
                }
            }
            j = ticketRepository.findAll().get(i).getId();
        }


    }

}
