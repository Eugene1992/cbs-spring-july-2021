package com.cbs.edu.springbootsecurityjwt.controller.request;

import com.cbs.edu.springbootsecurityjwt.model.Priority;
import com.cbs.edu.springbootsecurityjwt.model.Status;
import lombok.Data;

@Data
public class TicketCreationRequest {
    private String title;
    private String description;
    private Integer assigneeId;
    private Integer reporterId;
    private Priority priority;
}
