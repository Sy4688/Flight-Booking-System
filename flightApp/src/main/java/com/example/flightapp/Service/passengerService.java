package com.example.flightapp.Service;

import com.example.flightapp.Model.passengerModel;
import com.example.flightapp.Repository.passengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class passengerService {
    @Autowired
    public passengerRepository passengerRepository;

    public passengerModel addPassenger(passengerModel passenger){
        return passengerRepository.save(passenger);
    }

    public List<passengerModel> getPassengers(){
        return passengerRepository.findAll();
    }

    public passengerModel updatePassenger(String id, passengerModel passenger){
        passengerModel existing=passengerRepository.findById(id).orElse(null);
        if(existing!=null){
            existing.setPassengerName(passenger.getPassengerName());
            existing.setAge(passenger.getAge());
            existing.setGender(passenger.getGender());
            existing.setFlightId(passenger.getFlightId());

            return passengerRepository.save(existing);
        }
        return null;
    }

    public passengerModel getPassengerById(String id){
        return passengerRepository.findById(id).orElse(null);
    }

    public String deletePassenger(String id){
        passengerRepository.deleteById(id);
        return "Passenger deleted";
    }

    public passengerModel findByFlightId(String flightId){
        return passengerRepository.findByFlightId(flightId);
    }
}
