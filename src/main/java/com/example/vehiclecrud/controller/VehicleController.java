package com.example.vehiclecrud.controller;

import com.example.vehiclecrud.dto.VehicleDto;
import com.example.vehiclecrud.exception.NotFoundException;
import com.example.vehiclecrud.model.Vehicle;
import com.example.vehiclecrud.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable Long id) {
        try {
            Vehicle vehicle = vehicleService.getById(id);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } catch (NotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAll() {
        List<Vehicle> vehicles = vehicleService.getAll();
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehicle> create(@RequestBody VehicleDto vehicleDto) {
        Vehicle newVehicle = vehicleService.create(vehicleDto);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Vehicle> update(@PathVariable Long id, @RequestBody VehicleDto vehicleDto) {
        try {
            Vehicle updatedVehicle = vehicleService.update(id, vehicleDto);
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        } catch (NotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        try {
            vehicleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException exception) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
