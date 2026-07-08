package com.example.flightapp.Controller;

import com.example.flightapp.Model.passengerModel;
import com.example.flightapp.Service.passengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
@CrossOrigin(origins = "*")
public class passengerController {
    @Autowired
    public passengerService passengerService;

    @PostMapping
    public passengerModel addPassenger(@RequestBody passengerModel passenger){
        return passengerService.addPassenger(passenger);
    }

    @GetMapping("/allPassengers")
    public List<passengerModel> getPassengers(){
        return passengerService.getPassengers();
    }

    @PutMapping
    public passengerModel updatePassenger(@RequestBody String id, passengerModel passenger){
       return passengerService.updatePassenger(id,passenger);
    }

    @GetMapping("/passengers/{id}")
    public passengerModel getPassengerById(@PathVariable String id){
        return passengerService.getPassengerById(id);
    }

    @DeleteMapping("/{id}")
    public String deletePassenger(@PathVariable String id){
        passengerService.deletePassenger(id);
        return "Passenger Deleted";
    }

    @GetMapping("/passenger/{flightId}")
    public passengerModel findByFlightId(@PathVariable String flightId){
        return passengerService.findByFlightId(flightId);
    }
}
