package com.project.User.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import org.apache.kafka.common.serialization.StringSerializer;
import com.project.User.dto.CartDTO;

@Configuration
public class KafkaConfiguration {
	
	@Bean
	public ProducerFactory<String, String> producerFactory(){
		Map<String,Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		return new DefaultKafkaProducerFactory<String,String>(config);
	}
	
	@Bean
    KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<String, String>(producerFactory());
    }

}
