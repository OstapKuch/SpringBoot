package com.iot.controller;


import com.iot.exception.ResourceNotFoundException;
import com.iot.model.Apartments;
import com.iot.repository.ApartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApartmentsController {

    @Autowired
    private ApartmentsRepository objectRepository;

    @GetMapping("/apartment")
    public List<Apartments> getAll() {
        return objectRepository.findAll();
    }

    @PostMapping("/apartment")
    public Apartments create(@Valid @RequestBody Apartments object) {
        return objectRepository.save(object);
    }

    @GetMapping("/apartment/{id}")
    public Apartments getById(@PathVariable(value = "id") Integer id) {
        return objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apartment", "id", id));
    }

    @PutMapping("/apartment/{id}")
    public Apartments update(@PathVariable(value = "id") Integer id,
                             @Valid @RequestBody Apartments objectDetails) {

        Apartments object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apartment", "id", id));

        object.setAddress(objectDetails.getAddress());
        object.setBedsNumber(objectDetails.getBedsNumber());
        object.setHourPrice(objectDetails.getHourPrice());
        object.setRoomsNumber(objectDetails.getRoomsNumber());
        object.setSellerId(objectDetails.getSellerId());

        Apartments updatedObject = objectRepository.save(object);
        return updatedObject;
    }

    @DeleteMapping("/apartment/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Apartments object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apartment", "id", id));

        objectRepository.delete(object);

        return ResponseEntity.ok().build();
    }
}
