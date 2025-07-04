package com.faye.mqtt.configuration;

import com.faye.mqtt.Properties.MqttConfigurationProperties;
import com.faye.mqtt.handler.ReceiverMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class MqttInboundConfiguration {

    @Autowired
    private MqttConfigurationProperties  mqttConfigurationProperties;

    @Autowired
    private MqttPahoClientFactory mqttClientFactory;

    @Autowired
    private ReceiverMessageHandler receiverMessageHandler;
    /**
     * 配置消息传输通道
     * @return
     */
    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer messageProducer(){
        MqttPahoMessageDrivenChannelAdapter mqttPahoMessageDrivenChannelAdapter =new MqttPahoMessageDrivenChannelAdapter(
                mqttConfigurationProperties.getUrl(),
                mqttConfigurationProperties.getSubClientId(),
                mqttClientFactory,
                mqttConfigurationProperties.getSubTopic().split(",")

        );
        mqttPahoMessageDrivenChannelAdapter.setQos(1);
        mqttPahoMessageDrivenChannelAdapter.setConverter(new DefaultPahoMessageConverter());
        mqttPahoMessageDrivenChannelAdapter.setOutputChannel(mqttInputChannel());
        return mqttPahoMessageDrivenChannelAdapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler messageHandler(){
        return this.receiverMessageHandler;
    }
}
