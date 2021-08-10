package com.cbs.edu.springbootsecurityjwt.dto;

import static java.util.Objects.nonNull;

import com.cbs.edu.springbootsecurityjwt.dto.mappers.EntityDtoMapper;
import com.cbs.edu.springbootsecurityjwt.model.Priority;
import com.cbs.edu.springbootsecurityjwt.model.Status;
import com.cbs.edu.springbootsecurityjwt.model.Ticket;
import com.cbs.edu.springbootsecurityjwt.model.TicketType;
import com.cbs.edu.springbootsecurityjwt.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto implements EntityDtoMapper<Ticket, TicketDto> {
    private Integer id;
    private String key;
    private String title;
    private String description;
    private UserDto assignee;
    private UserDto reporter;
    private Long loggedHours;
    private Priority priority;
    private Status status;
    private TicketType type;

    @Override
    public TicketDto map(Ticket ticket) {
        TicketDtoBuilder builder = TicketDto.builder()
                .id(ticket.getId())
                .key(ticket.getKey())
                .title(ticket.getTitle())
                .description(ticket.getDescription())
                .loggedHours(ticket.getLoggedHours())
                .priority(ticket.getPriority())
                .type(ticket.getType())
                .status(ticket.getStatus());

        User assignee = ticket.getAssignee();
        if (nonNull(assignee)) {
            builder.assignee(new UserDto().map(assignee));
        }

        User reporter = ticket.getReporter();
        if (nonNull(reporter)) {
            builder.reporter(new UserDto().map(reporter));
        }

        return builder.build();
    }
}
