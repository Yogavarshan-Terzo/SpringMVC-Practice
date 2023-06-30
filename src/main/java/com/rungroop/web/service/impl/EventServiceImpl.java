package com.rungroop.web.service.impl;

import com.rungroop.web.dto.EventDto;
import com.rungroop.web.models.Club;
import com.rungroop.web.models.Event;
import com.rungroop.web.repository.ClubRepository;
import com.rungroop.web.repository.EventRepository;
import com.rungroop.web.service.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    ClubRepository clubRepository;
    EventRepository eventRepository;

    public EventServiceImpl(ClubRepository clubRepository, EventRepository eventRepository) {
        this.clubRepository = clubRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    private Event mapToEvent(EventDto eventDto) {
        Event event = Event.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .photoUrl(eventDto.getPhotoUrl())
                .createdOn(eventDto.getCreatedOn())
                .updatedOn(eventDto.getUpdatedOn())
                .build();
        return event;
    }
}
