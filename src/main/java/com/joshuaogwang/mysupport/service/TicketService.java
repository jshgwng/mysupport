package com.joshuaogwang.mysupport.service;

import com.joshuaogwang.mysupport.entity.Ticket;
import com.joshuaogwang.mysupport.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow();
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(Long id, Ticket ticket) {
        Ticket ticket1 = ticketRepository.findById(id).orElseThrow();
        ticket1.setUpdatedAt(LocalDateTime.now());
        ticket1.setPriority(ticket.getPriority());
        ticket1.setStatus(ticket.getStatus());
        ticket1.setDescription(ticket.getDescription());
        ticket1.setTitle(ticket.getTitle());
        return ticketRepository.save(ticket1);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    public List<Ticket> getTicketsByStatus(String status) {
        return ticketRepository.getTicketsByStatus(status);
    }
}
