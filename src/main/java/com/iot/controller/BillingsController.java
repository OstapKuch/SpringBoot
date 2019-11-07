package com.iot.controller;


import com.iot.exception.ResourceNotFoundException;
import com.iot.model.Billings;
import com.iot.repository.BillingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BillingsController {

    @Autowired
    private BillingsRepository objectRepository;

    @GetMapping("/billings")
    public List<Billings> getAll() {
        return objectRepository.findAll();
    }

    @PostMapping("/billings")
    public Billings create(@Valid @RequestBody Billings object) {
        return objectRepository.save(object);
    }

    @GetMapping("/billings/{id}")
    public Billings getById(@PathVariable(value = "id") Integer id) {
        return objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Billings", "id", id));
    }

    @PutMapping("/billings/{id}")
    public Billings update(@PathVariable(value = "id") Integer id,
                           @Valid @RequestBody Billings objectDetails) {

        Billings object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Billings", "id", id));

        object.setBuyersId(objectDetails.getBuyersId());
        object.setPrice(objectDetails.getPrice());
        object.setSellersId(objectDetails.getSellersId());
        object.setSettlementDate(objectDetails.getSettlementDate());

        Billings updatedObject = objectRepository.save(object);
        return updatedObject;
    }

    @DeleteMapping("/billings/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        Billings object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Billings", "id", id));

        objectRepository.delete(object);

        return ResponseEntity.ok().build();
    }
}
