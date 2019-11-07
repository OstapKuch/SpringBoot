package com.iot.controller;


import com.iot.exception.ResourceNotFoundException;
import com.iot.model.Sellers;
import com.iot.repository.SellersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SellersController {

    @Autowired
    private SellersRepository objectRepository;

    @GetMapping("/seller")
    public List<Sellers> getAll() {
        return objectRepository.findAll();
    }

    @PostMapping("/seller")
    public Sellers create(@Valid @RequestBody Sellers object) {
        return objectRepository.save(object);
    }

    @GetMapping("/seller/{id}")
    public Sellers getById(@PathVariable(value = "id") Integer id) {
        return objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "id", id));
    }

    @PutMapping("/seller/{id}")
    public Sellers update(@PathVariable(value = "id") Integer id,
                               @Valid @RequestBody Sellers objectDetails) {

        Sellers object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "id", id));

        object.setBirthday(objectDetails.getBirthday());
        object.setEmail(objectDetails.getEmail());
        object.setName(objectDetails.getName());
        object.setSurname(objectDetails.getSurname());
        object.setPhoneNumber(objectDetails.getPhoneNumber());


        Sellers updatedObject = objectRepository.save(object);
        return updatedObject;
    }

    @DeleteMapping("/seller/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Sellers object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller", "id", id));

        objectRepository.delete(object);

        return ResponseEntity.ok().build();
    }
}
