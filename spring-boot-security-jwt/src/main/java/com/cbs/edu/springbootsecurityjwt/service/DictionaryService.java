package com.cbs.edu.springbootsecurityjwt.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.cbs.edu.springbootsecurityjwt.model.Label;
import com.cbs.edu.springbootsecurityjwt.model.Priority;
import com.cbs.edu.springbootsecurityjwt.model.TicketType;
import com.cbs.edu.springbootsecurityjwt.repository.LabelRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DictionaryService {

    public Iterable<?> getAllDictionaries(String name) {
        switch (name) {
            case "priority":
                return getPriorities();

            case "ticketType":
                return getTicketTypes();
        }

        return new ArrayList<>();
    }

    public Iterable<?> getPriorities() {
        return Arrays.asList(Priority.values());

    }

    public Iterable<?> getTicketTypes() {
        return Arrays.asList(TicketType.values());
    }
}
