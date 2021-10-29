package com.GregV3.SpringBootV3.controllers;

import com.GregV3.SpringBootV3.model.Car;
import com.GregV3.SpringBootV3.service.ConsumingRestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private ConsumingRestApiService consumingRestApiService;

    @GetMapping(value = "/Cars")
    public List<Car> LaListeDesVoitures() {
        return consumingRestApiService.ListeDesVoitures();
    }

    @GetMapping(value = "/Cars/{id}")
    public Car BelleVoiture(@PathVariable int id) {
        return consumingRestApiService.AfficherUneBelleVoiture(id);
    }

    @DeleteMapping(value = "/Cars/{id}")
    public Boolean DestructionDeLaCaisse(@PathVariable int id){
        return consumingRestApiService.SupprimerLaCaisse(id);
    }

    @PostMapping(value = "/Cars/add")
    public Car AcheteLaJteDis(@RequestBody Car newCar){
        return consumingRestApiService.RentreLaCaisseDansLeGarage(newCar);
    }

    @PutMapping(value="/Cars/{id}")
    public Car TunningSurLaBagnole(@RequestBody Car updateCar, @PathVariable int id){
        return consumingRestApiService.OnVaPimperTaCaisse(updateCar,id);
    }
}

