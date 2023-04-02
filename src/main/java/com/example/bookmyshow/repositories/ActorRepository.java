package com.example.bookmyshow.repositories;

import com.example.bookmyshow.models.Actor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

// Repository created by myself and not by using Spring
@Repository
public class ActorRepository {
    private Map<Integer, Actor> actors = new HashMap<>();
    private int lastIdCount = 0;
    public Actor save(Actor actor){
        lastIdCount+=1;
        actor.setId(lastIdCount);
        actors.put(lastIdCount,actor);
        return actor;
    }
}
