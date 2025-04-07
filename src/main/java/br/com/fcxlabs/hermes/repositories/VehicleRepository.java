package br.com.fcxlabs.hermes.repositories;

import br.com.fcxlabs.hermes.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
