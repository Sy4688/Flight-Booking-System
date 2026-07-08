package com.example.flightapp.Repository;

import com.example.flightapp.Model.passengerModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface passengerRepository extends MongoRepository<passengerModel, String> {
    public passengerModel findByFlightId(String flightId);
}
