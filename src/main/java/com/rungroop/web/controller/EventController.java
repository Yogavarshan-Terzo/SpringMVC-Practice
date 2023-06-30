package com.rungroop.web.controller;

import com.rungroop.web.dto.ClubDto;
import com.rungroop.web.dto.EventDto;
import com.rungroop.web.models.Event;
import com.rungroop.web.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    private EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("/events")
    public String eventList(Model model){
        List<EventDto> eventDtos = eventService.findAllEvents();
        model.addAttribute("events",eventDtos);
        return "events-list";
    }
    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Long eventId, Model model){
        EventDto eventDto = eventService.findByEventId(eventId);
        model.addAttribute("event",eventDto);
        return "event-detail";
    }
    @GetMapping("/events/{clubId}/new")
    public String createEventForm(@PathVariable("clubId") Long clubId, Model model){
        Event event = new Event();
        model.addAttribute("clubId",clubId);
        model.addAttribute("event",event);
        return "create-event";
    }
    @PostMapping("/events/{clubId}")
    public String createEvent(@PathVariable("clubId") Long clubId, @ModelAttribute("event")EventDto eventDto, Model model, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("event",eventDto);
            return "create-event ";
        }
        eventService.createEvent(clubId,eventDto);
        return "redirect:/clubs/" + clubId;
    }
    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") Long eventId, Model model){
        EventDto event = eventService.findByEventId(eventId);
        model.addAttribute("event",event);
        return "event-edit";
    }
    @PostMapping("/events/{eventId}/edit")
    public String updateClub(@PathVariable("eventId") Long eventId, @Valid @ModelAttribute("event") EventDto eventDto, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("event",eventDto);
            return "event-edit";
        }
        EventDto event = eventService.findByEventId(eventId);
        eventDto.setId(eventId);
        eventDto.setClub(event.getClub());
        eventService.updateEvent(eventDto);
        return "redirect:/events";
    }

}
