package com.iot.controller;


import com.iot.exception.ResourceNotFoundException;
import com.iot.model.ApartmentsHasReservations;
import com.iot.repository.ApartmentsHasReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApartmentsHasReservationsController {

    @Autowired
    private ApartmentsHasReservationsRepository objectRepository;

    @GetMapping("/apartmentHasReservations")
    public List<ApartmentsHasReservations> getAll() {
        return objectRepository.findAll();
    }

    @PostMapping("/apartmentHasReservations")
    public ApartmentsHasReservations create(@Valid @RequestBody ApartmentsHasReservations object) {
        return objectRepository.save(object);
    }

    @GetMapping("/apartmentHasReservations/{id}")
    public ApartmentsHasReservations getById(@PathVariable(value = "id") Integer id) {
        return objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApartmentHasReservations", "id", id));
    }

    @PutMapping("/apartmentHasReservations/{id}")
    public ApartmentsHasReservations update(@PathVariable(value = "id") Integer id,
                                            @Valid @RequestBody ApartmentsHasReservations objectDetails) {

        ApartmentsHasReservations object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApartmentHasReservations", "id", id));

        object.setId(objectDetails.getId());
        object.setAirbnbWalletId(objectDetails.getAirbnbWalletId());
        object.setApartmentsId(objectDetails.getApartmentsId());
        object.setBillingsId(objectDetails.getBillingsId());
        object.setBuyersId(objectDetails.getBuyersId());


        ApartmentsHasReservations updatedObject = objectRepository.save(object);
        return updatedObject;
    }

    @DeleteMapping("/apartmentHasReservations/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        ApartmentsHasReservations object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ApartmentHasReservations", "id", id));

        objectRepository.delete(object);

        return ResponseEntity.ok().build();
    }
}
