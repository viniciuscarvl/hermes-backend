package br.com.fcxlabs.hermes.dtos.sequential;

import java.util.List;

public record saveSequentialRequest(
        Long id,
        Long vehicleId,
        List<Long> ordersIds
) { }
