package com.joshuaogwang.mysupport.repository;

import com.joshuaogwang.mysupport.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> getTicketsByStatus(String status);
}
