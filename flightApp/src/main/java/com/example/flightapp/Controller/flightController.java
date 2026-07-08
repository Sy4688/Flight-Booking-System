package com.example.flightapp.Controller;

import com.example.flightapp.Model.flightModel;
import com.example.flightapp.Service.flightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "*")
public class flightController {

    @Autowired
    private flightService service;

    @PostMapping
    public flightModel addFlight(@RequestBody flightModel flight) {
        return service.addFlight(flight);
    }

    @GetMapping
    public List<flightModel> getFlights() {
        return service.getAllFlights();
    }

    @GetMapping("/{id}")
    public flightModel getFlight(@PathVariable String id) {
        return service.getFlightById(id);
    }

    @PutMapping("/{id}")
    public flightModel updateFlight(@PathVariable String id, @RequestBody flightModel flight) {
        return service.updateFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable String id) {
        service.deleteFlight(id);
        return "Deleted Successfully";
    }
}
