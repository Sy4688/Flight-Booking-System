package com.example.flightapp.Service;

import com.example.flightapp.Model.flightModel;
import com.example.flightapp.Repository.flightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class flightService {

    @Autowired
    private flightRepository repo;

    public flightModel addFlight(flightModel flight) {
        return repo.save(flight);
    }

    public List<flightModel> getAllFlights() {
        return repo.findAll();
    }

    public flightModel getFlightById(String id) {
        return repo.findById(id).orElse(null);
    }

    public flightModel updateFlight(String id, flightModel flight) {
        flightModel f = repo.findById(id).orElse(null);

        if (f != null) {
            f.setFlightName(flight.getFlightName());
            f.setSource(flight.getSource());
            f.setDestination(flight.getDestination());
            f.setDate(flight.getDate());
            f.setPrice(flight.getPrice());
            return repo.save(f);
        }

        return null;
    }

    public void deleteFlight(String id) {
        repo.deleteById(id);
    }
}