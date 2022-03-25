package com.example.vehiclecrud.service;

import com.example.vehiclecrud.dto.VehicleDto;
import com.example.vehiclecrud.exception.NotFoundException;
import com.example.vehiclecrud.model.Vehicle;
import com.example.vehiclecrud.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle getById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle create(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(vehicleDto.getName());
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle update(Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new NotFoundException());
        vehicle.setName(vehicleDto.getName());
        return vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new NotFoundException());
        vehicleRepository.deleteById(vehicle.getId());
    }
}
