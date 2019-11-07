package com.iot.controller;


import com.iot.exception.ResourceNotFoundException;
import com.iot.model.AirbnbWallet;
import com.iot.repository.AirbnbWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AirbnbWalletController {

    @Autowired
    private AirbnbWalletRepository objectRepository;

    @GetMapping("/airbnbWallet")
    public List<AirbnbWallet> getAll() {
        return objectRepository.findAll();
    }

    @PostMapping("/airbnbWallet")
    public AirbnbWallet create(@Valid @RequestBody AirbnbWallet airbnbWallet) {
        return objectRepository.save(airbnbWallet);
    }

    @GetMapping("/airbnbWallet/{id}")
    public AirbnbWallet getById(@PathVariable(value = "id") Integer id) {
        return objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AirbnbWallet", "id", id));
    }

    @PutMapping("/airbnbWallet/{id}")
    public AirbnbWallet update(@PathVariable(value = "id") Integer id,
                               @Valid @RequestBody AirbnbWallet objectDetails) {

        AirbnbWallet object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AirbnbWallet", "id", id));

        object.setMoney(objectDetails.getMoney());

        AirbnbWallet updatedObject = objectRepository.save(object);
        return updatedObject;
    }

    @DeleteMapping("/airbnbWallet/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        AirbnbWallet object = objectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AirbnbWallet", "id", id));

        objectRepository.delete(object);

        return ResponseEntity.ok().build();
    }
}
