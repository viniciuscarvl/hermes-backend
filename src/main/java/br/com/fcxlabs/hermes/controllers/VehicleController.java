package br.com.fcxlabs.hermes.controllers;

import br.com.fcxlabs.hermes.dtos.vehicle.saveVehicleRequest;
import br.com.fcxlabs.hermes.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/vehicles")
public class VehicleController {
     private VehicleService vehicleService;

     public VehicleController(VehicleService vehicleService) {
         this.vehicleService = vehicleService;
     }

     @PostMapping
     public ResponseEntity<?> saveVehicle(@RequestBody saveVehicleRequest request) {
         return ResponseEntity.ok(vehicleService.saveVehicle(request));
     }
}
