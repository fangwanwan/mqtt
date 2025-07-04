package com.faye.mqtt.configuration;

import com.faye.mqtt.Properties.MqttConfigurationProperties;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;

@Configuration
public class MqttConfiguration {

    @Autowired
    private MqttConfigurationProperties mqttConfigurationProperties;

    @Bean
    public MqttPahoClientFactory mqttClientFactory(){

        //创建客户端工厂
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();

        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setCleanSession(true);
        mqttConnectOptions.setUserName(mqttConfigurationProperties.getUsername());
        mqttConnectOptions.setPassword(mqttConfigurationProperties.getPassword().toCharArray());
        mqttConnectOptions.setServerURIs(new String[]{mqttConfigurationProperties.getUrl()});
        factory.setConnectionOptions(mqttConnectOptions);

        return factory;
    }
}
