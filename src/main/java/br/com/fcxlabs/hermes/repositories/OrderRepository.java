package br.com.fcxlabs.hermes.repositories;

import br.com.fcxlabs.hermes.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
