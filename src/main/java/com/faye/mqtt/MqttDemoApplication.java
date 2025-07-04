package com.faye.mqtt;

import com.faye.mqtt.Properties.MqttConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = MqttConfigurationProperties.class)
public class MqttDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MqttDemoApplication.class,args);
    }
}
