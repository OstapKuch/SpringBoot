package com.iot.controller;


import com.iot.exception.ResourceNotFoundException;
import com.iot.model.Buyers;
import com.iot.repository.BuyersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BuyersController {

    @Autowired
    private BuyersRepository objectRepository;

    @GetMapping("/buyer")
    public List<Buyers> getAll() {
        return objectRepository.findAll();
    }

    @PostMapping("/buyer")
    public Buyers create(@Valid @RequestBody Buyers object) {
        return objectRepository.save(object);
    }

    @GetMapping("/buyer/{id}")
    public Buyers getById(@PathVariable(value = "id") Integer id) {
        return objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer", "id", id));
    }

    @PutMapping("/buyer/{id}")
    public Buyers update(@PathVariable(value = "id") Integer id,
                         @Valid @RequestBody Buyers objectDetails) {

        Buyers object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer", "id", id));

        object.setBirthday(objectDetails.getBirthday());
        object.setEmail(objectDetails.getEmail());
        object.setName(objectDetails.getName());
        object.setSurname(objectDetails.getSurname());
        object.setPhoneNumber(objectDetails.getPhoneNumber());


        Buyers updatedObject = objectRepository.save(object);
        return updatedObject;
    }

    @DeleteMapping("/buyer/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Buyers object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Buyer", "id", id));

        objectRepository.delete(object);

        return ResponseEntity.ok().build();
    }
}
