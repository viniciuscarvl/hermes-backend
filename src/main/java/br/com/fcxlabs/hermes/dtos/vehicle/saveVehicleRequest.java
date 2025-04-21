package br.com.fcxlabs.hermes.dtos.vehicle;

public record saveVehicleRequest(
        String name,
        String plate,
        Long trackerId
) { }
