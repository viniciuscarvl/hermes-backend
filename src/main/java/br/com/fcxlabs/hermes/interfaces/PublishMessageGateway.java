package br.com.fcxlabs.hermes.interfaces;

import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface PublishMessageGateway {
    void sendToMqtt(String data);
}
