package com.example.bookmyshow.services;
import com.example.bookmyshow.models.Actor;
import com.example.bookmyshow.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    private ActorRepository actorRepository;
    @Autowired
    public ActorService(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }
    public Actor createActor(String name){
        Actor actor = new Actor();
        actor.setName(name);
        return actorRepository.save(actor);
    }
}
