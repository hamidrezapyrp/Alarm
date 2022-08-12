package net.fakour.alarm.repository;

import net.fakour.alarm.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Transactional
    @Modifying
    @Query(value = "update Ticket t set t.status =:status  where t.id=:id")
    public void update(Integer id, boolean status);
    @Override
    public List<Ticket> findAll();

    public List<Ticket> findAllByStatus(boolean a);

    public List<Ticket> findAllByErrorType(String b);

    public List<Ticket> findAllByStatusIsTrueAndErrorType(String b);

}
