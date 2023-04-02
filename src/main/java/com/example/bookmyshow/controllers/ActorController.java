package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.CreateActorRequestDTO;
import com.example.bookmyshow.dtos.CreateActorResponseDTO;
import com.example.bookmyshow.models.Actor;
import com.example.bookmyshow.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ActorController {
    private ActorService actorService;
    @Autowired
    public ActorController(ActorService actorService){
        this.actorService = actorService;
    }
    public CreateActorResponseDTO createActor(CreateActorRequestDTO request){
        String name = request.getName();
        Actor actor = actorService.createActor(name);
        CreateActorResponseDTO response = new CreateActorResponseDTO();
        response.setActor(actor);
        return response;
    }
}
