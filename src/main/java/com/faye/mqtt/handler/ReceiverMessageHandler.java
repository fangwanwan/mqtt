package com.faye.mqtt.handler;

import com.faye.mqtt.Properties.MqttConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class ReceiverMessageHandler implements MessageHandler {

    @Autowired
    private MqttConfigurationProperties mqttConfigurationProperties;

    @Override
    public void handleMessage(Message<?> message) throws MessagingException {
        MessageHeaders headers = message.getHeaders();
        String mqttReceivedTopic = headers.get("mqtt_receivedTopic").toString();
        if(mqttConfigurationProperties.getSubTopic().equals(mqttReceivedTopic)){
            System.out.println("Received Message from MQTT topic: " + message.getPayload());
        }
    }
}
