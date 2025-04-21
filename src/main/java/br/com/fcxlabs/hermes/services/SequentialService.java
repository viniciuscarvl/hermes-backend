package br.com.fcxlabs.hermes.services;

import br.com.fcxlabs.hermes.dtos.sequential.saveSequentialRequest;
import br.com.fcxlabs.hermes.entities.Order;
import br.com.fcxlabs.hermes.entities.Sequential;
import br.com.fcxlabs.hermes.entities.Vehicle;
import br.com.fcxlabs.hermes.repositories.SequentialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SequentialService {
    private VehicleService vehicleService;
    private SequentialRepository sequentialRepository;

    public SequentialService(VehicleService vehicleService, SequentialRepository sequentialRepository) {
        this.vehicleService = vehicleService;
        this.sequentialRepository = sequentialRepository;
    }

    public Sequential saveSequential(saveSequentialRequest request) {
        Vehicle vehicle = vehicleService.findById(request.vehicleId());
        List<Order> orders = request.ordersIds().stream()
                .map(orderId -> {
                    Order order = new Order();
                    order.setId(orderId);
                    order.setDelivered(false);
                    return order;
                })
                .toList();

        Sequential sequential = new Sequential();
        sequential.setId(request.id());
        sequential.setVehicle(vehicle);
        sequential.setOrders(orders);
        sequential.setFinished(false);
        return sequentialRepository.save(sequential);
    }
}
