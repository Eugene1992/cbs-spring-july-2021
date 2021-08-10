package com.cbs.edu.springbootsecurityjwt.service;

import org.springframework.stereotype.Service;

import com.cbs.edu.springbootsecurityjwt.controller.request.TicketCreationRequest;
import com.cbs.edu.springbootsecurityjwt.dto.TicketDto;
import com.cbs.edu.springbootsecurityjwt.model.Status;
import com.cbs.edu.springbootsecurityjwt.model.Ticket;
import com.cbs.edu.springbootsecurityjwt.model.User;
import com.cbs.edu.springbootsecurityjwt.repository.TicketRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository repository;
    private final UserService userService;

    public TicketDto getTicket(Integer id) {
        final Ticket ticket = repository.findById(id).get();

        return new TicketDto().map(ticket);
    }

    public Ticket createTicket(TicketCreationRequest creationRequest) {

        Ticket newTicket = new Ticket();

        newTicket.setTitle(creationRequest.getTitle());
        newTicket.setDescription(creationRequest.getDescription());
        newTicket.setPriority(creationRequest.getPriority());
        newTicket.setStatus(Status.OPEN);

        Integer reporterId = creationRequest.getReporterId();
        User reporter = userService.getById(reporterId);
        newTicket.setReporter(reporter);

        Integer assigneeId = creationRequest.getAssigneeId();
        if (assigneeId != null) {
            User assignee = userService.getById(assigneeId);
            newTicket.setAssignee(assignee);
        }

        return repository.save(newTicket);
    }
}
