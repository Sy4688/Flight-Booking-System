package com.example.flightapp.Repository;

import com.example.flightapp.Model.flightModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface flightRepository extends MongoRepository<flightModel, String> {
}
