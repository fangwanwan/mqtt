package com.faye.mqtt.service;

import com.faye.mqtt.gateway.MqttGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
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
