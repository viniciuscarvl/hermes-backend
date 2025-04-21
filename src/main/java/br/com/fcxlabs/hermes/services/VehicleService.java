package br.com.fcxlabs.hermes.services;

import br.com.fcxlabs.hermes.dtos.vehicle.saveVehicleRequest;
import br.com.fcxlabs.hermes.entities.Tracker;
import br.com.fcxlabs.hermes.entities.Vehicle;
import br.com.fcxlabs.hermes.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    private TrackerService trackerService;
    private VehicleRepository vehicleRepository;

    public VehicleService(TrackerService trackerService, VehicleRepository vehicleRepository) {
        this.trackerService = trackerService;
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
    }

    public Vehicle saveVehicle(saveVehicleRequest request) {
        Tracker tracker = trackerService.findById(request.trackerId());

        Vehicle vehicle = new Vehicle();
        vehicle.setName(request.name());
        vehicle.setPlate(request.plate());
        vehicle.setTracker(tracker);
        return vehicleRepository.save(vehicle);
    }
}
