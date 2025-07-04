package com.faye.mqtt.test;

import com.faye.mqtt.MqttDemoApplication;
import com.faye.mqtt.service.MqttMessageSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MqttDemoApplication.class)
public class MqttMessageSenderTest {

    @Autowired
    private MqttMessageSender mqttMessageSender;

    @Test
    public void sendMqttMessage() {
        mqttMessageSender.sendMqttMessage("testtopic/a","hello mqtt");
    }
}
