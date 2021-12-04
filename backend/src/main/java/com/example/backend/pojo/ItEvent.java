package com.example.backend.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document("event")
public class ItEvent {

    @Id
    private String _id;

    private String title;
    private String type;
    private String comm_method;
    private ArrayList participants;
    private ArrayList td_participants;

    public ItEvent() {
    }

    public ItEvent(String _id, String title, String type, String comm_method, ArrayList participants, ArrayList td_participants) {
        this._id = _id;
        this.title = title;
        this.type = type;
        this.comm_method = comm_method;
        this.participants = participants;
        this.td_participants = td_participants;
    }
}
