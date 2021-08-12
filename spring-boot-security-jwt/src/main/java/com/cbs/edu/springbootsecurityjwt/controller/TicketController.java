package com.cbs.edu.springbootsecurityjwt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.edu.springbootsecurityjwt.controller.request.TicketCreationRequest;
import com.cbs.edu.springbootsecurityjwt.dto.TicketDto;
import com.cbs.edu.springbootsecurityjwt.model.Ticket;
import com.cbs.edu.springbootsecurityjwt.service.TicketService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
@CrossOrigin
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/{id}")
    public TicketDto getTicket(@PathVariable Integer id) {
        return ticketService.getTicketDto(id);
    }

    @GetMapping("/{id}/watchers/count")
    public Integer getTicketWatchersCount(@PathVariable Integer id) {
        return ticketService.getTicketWatchersCount(id);
    }

    @PostMapping
    public Ticket createTicket(@RequestBody TicketCreationRequest creationRequest) {
        return ticketService.createTicket(creationRequest);
    }
}
