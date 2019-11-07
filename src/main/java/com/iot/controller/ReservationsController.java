package com.iot.controller;


import com.iot.exception.ResourceNotFoundException;
import com.iot.model.Reservations;
import com.iot.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationsController {

    @Autowired
    private ReservationsRepository objectRepository;

    @GetMapping("/reservation")
    public List<Reservations> getAll() {
        return objectRepository.findAll();
    }

    @PostMapping("/reservation")
    public Reservations create(@Valid @RequestBody Reservations object) {
        return objectRepository.save(object);
    }

    @GetMapping("/reservation/{id}")
    public Reservations getById(@PathVariable(value = "id") Integer id) {
        return objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", id));
    }

    @PutMapping("/reservation/{id}")
    public Reservations update(@PathVariable(value = "id") Integer id,
                               @Valid @RequestBody Reservations objectDetails) {

        Reservations object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", id));

        object.setLeaveDate(objectDetails.getLeaveDate());
        object.setPaid(objectDetails.getPaid());
        object.setSettlementDate(objectDetails.getSettlementDate());

        Reservations updatedObject = objectRepository.save(object);
        return updatedObject;
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Reservations object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", id));

        objectRepository.delete(object);

        return ResponseEntity.ok().build();
    }
}
