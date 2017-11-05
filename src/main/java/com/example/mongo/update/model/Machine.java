package com.example.mongo.update.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "machine")
public class Machine {

    private String id;
    private String name;
    private String team;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
