package br.com.fcxlabs.hermes.services;

import br.com.fcxlabs.hermes.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
