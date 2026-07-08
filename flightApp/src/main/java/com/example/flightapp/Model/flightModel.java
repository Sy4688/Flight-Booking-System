package com.example.flightapp.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "flights")
public class flightModel {

    @Id
    private String id;

    private String flightName;
    private String source;
    private String destination;
    private String date;
    private double price;
}