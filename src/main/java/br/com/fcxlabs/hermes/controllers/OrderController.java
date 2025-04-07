package br.com.fcxlabs.hermes.controllers;

import br.com.fcxlabs.hermes.dtos.OrderRequest;
import br.com.fcxlabs.hermes.dtos.OrderResponse;
import br.com.fcxlabs.hermes.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController(value = "/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    
}
