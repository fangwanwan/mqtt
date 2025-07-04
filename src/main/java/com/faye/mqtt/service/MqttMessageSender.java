package com.faye.mqtt.service;

import com.faye.mqtt.gateway.MqttGateway;
import lombok.AllArgsConstructor;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MqttMessageSender {

    private MqttGateway mqttGateway;

    public void sendMqttMessage(String topic,String payload) {
        mqttGateway.sendMqttMessage(topic,payload);
    }

    public void sendMqttMessage(String topic,int qos,String payload) {
        mqttGateway.sendMqttMessage(topic,qos,payload);
    }
}
