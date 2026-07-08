package com.example.flightapp.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="passengers")
public class passengerModel {
    @Id
    private String passengerId;

    private String passengerName;
    private String age;
    private String flightId;
    private String gender;
}
