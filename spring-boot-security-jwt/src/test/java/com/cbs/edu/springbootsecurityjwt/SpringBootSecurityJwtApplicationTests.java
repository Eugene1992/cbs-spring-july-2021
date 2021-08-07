package com.cbs.edu.springbootsecurityjwt;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.cbs.edu.springbootsecurityjwt.controller.request.TicketCreationRequest;
import com.cbs.edu.springbootsecurityjwt.model.Priority;
import com.cbs.edu.springbootsecurityjwt.model.Status;
import com.cbs.edu.springbootsecurityjwt.model.Ticket;
import com.cbs.edu.springbootsecurityjwt.model.User;
import com.cbs.edu.springbootsecurityjwt.repository.UserRepository;
import com.cbs.edu.springbootsecurityjwt.service.TicketService;
import com.cbs.edu.springbootsecurityjwt.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SpringBootSecurityJwtApplication.class)
class SpringBootSecurityJwtApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketService ticketService;

    private User reporter;

    @BeforeEach
    public void setup() {
        reporter = new User();
        reporter.setUsername("Yevhenii");
        userRepository.save(reporter);
    }

    @Test
    void contextLoads() {
        TicketCreationRequest creationRequest = new TicketCreationRequest();
        creationRequest.setTitle("Some ticket");
        creationRequest.setDescription("Some description");
        creationRequest.setPriority(Priority.BLOCKER);
        creationRequest.setReporterId(reporter.getId());

        Ticket ticket = ticketService.createTicket(creationRequest);

        Ticket savedTicket = ticketService.getTicket(ticket.getId());

        Assertions.assertEquals(ticket.getId(), savedTicket.getId());
        Assertions.assertEquals(savedTicket.getTitle(), creationRequest.getTitle());
        Assertions.assertEquals(savedTicket.getDescription(), creationRequest.getDescription());
        Assertions.assertEquals(savedTicket.getPriority(), creationRequest.getPriority());
        Assertions.assertEquals(savedTicket.getReporter().getId(), reporter.getId());
        Assertions.assertEquals(savedTicket.getStatus(), Status.OPEN);
    }

}
