package br.com.fcxlabs.hermes.configuration;

import br.com.fcxlabs.hermes.services.LocalizationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Configuration
public class MqttConfiguration {
    @Value("${mqtt.broker.url}")
    private String mqttBrokerUrl;
    @Value("${mqtt.broker.client.id}")
    private String mqttClientId;
    @Value("${mqtt.broker.username}")
    private String mqttBrokerUsername;
    @Value("${mqtt.broker.password}")
    private String mqttBrokerPassword;

    private LocalizationService localizationService;

    public MqttConfiguration(LocalizationService localizationService) {
        this.localizationService = localizationService;
    }

    // MQTT inbound configuration

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        String inboundClientId = mqttClientId + "-inbound";
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(mqttBrokerUrl, inboundClientId, mqttClientFactory(), "hermes-1");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> {
            try {
                this.localizationService.saveLocalization(message.getPayload().toString());
            } catch (JsonProcessingException e) {
                System.out.println(e.getMessage());
            }
        };
    }

    // MQTT outbound configuration

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{ mqttBrokerUrl});
        options.setUserName(mqttBrokerUsername);
        options.setPassword(mqttBrokerPassword.toCharArray());
        options.setCleanSession(true);
        options.setKeepAliveInterval(30);
        options.setAutomaticReconnect(true);
        options.setConnectionTimeout(30);
        factory.setConnectionOptions(options);
        return factory;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        String outboundClientId = mqttClientId + "-outbound";
        MqttPahoMessageHandler messageHandler =
                new MqttPahoMessageHandler(outboundClientId, mqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("hermes-1");
        return messageHandler;
    }

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }
}