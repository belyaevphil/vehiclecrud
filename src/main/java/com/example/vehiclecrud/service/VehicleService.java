package com.example.vehiclecrud.service;

import com.example.vehiclecrud.dto.VehicleDto;
import com.example.vehiclecrud.model.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle getById(Long id);
    List<Vehicle> getAll();
    Vehicle create(VehicleDto vehicleDto);
    Vehicle update(Long id, VehicleDto vehicleDto);
    void deleteById(Long id);

}
