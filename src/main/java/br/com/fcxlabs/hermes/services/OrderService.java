package br.com.fcxlabs.hermes.services;

import br.com.fcxlabs.hermes.dtos.OrderRequest;
import br.com.fcxlabs.hermes.dtos.OrderResponse;
import br.com.fcxlabs.hermes.entities.Order;
import br.com.fcxlabs.hermes.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponse createOrder(OrderRequest orderRequest) {
        // convert OrderRequest to Order entity
        // save Order entity to the database
        // convert saved Order entity to OrderResponse
        // return OrderResponse
        Order order = new Order();
        order.setId(orderRequest.getId());
        order = orderRepository.save(order);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());

    }
}
