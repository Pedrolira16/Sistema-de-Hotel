package com.hotel.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

	@Bean
	public Queue recepcionistaQueue() {
		return new Queue("hotel-recepcionista", false, false, true);
	}

	@Bean
	public Queue gerenteQueue() {
		return new Queue("hotel-gerente", false, false, true);
	}

	@Bean
	public Queue auditoriaQueue() {
		return new Queue("hotel-auditoria", false, false, false);
	}

	// Bindings para Recepcionista (Secretaria)
	@Bean
	public Binding recepcionistaNovaReservaBinding(TopicExchange topicExchange, Queue recepcionistaQueue) {
		return BindingBuilder.bind(recepcionistaQueue).to(topicExchange).with("hotel.nova_reserva");
	}

	@Bean
	public Binding recepcionistaAlteracaoReservaBinding(TopicExchange topicExchange, Queue recepcionistaQueue) {
		return BindingBuilder.bind(recepcionistaQueue).to(topicExchange).with("hotel.alteracao_reserva");
	}

	@Bean
	public Binding recepcionistaItemPerdidoBinding(TopicExchange topicExchange, Queue recepcionistaQueue) {
		return BindingBuilder.bind(recepcionistaQueue).to(topicExchange).with("hotel.item_perdido");
	}

	@Bean
	public Binding recepcionistaEmergenciaBinding(TopicExchange topicExchange, Queue recepcionistaQueue) {
		return BindingBuilder.bind(recepcionistaQueue).to(topicExchange).with("hotel.emergencia");
	}

	// Bindings para Gerente (Gerência)
	@Bean
	public Binding gerenteRelatorioDiarioBinding(TopicExchange topicExchange, Queue gerenteQueue) {
		return BindingBuilder.bind(gerenteQueue).to(topicExchange).with("hotel.relatorio_diario");
	}

	@Bean
	public Binding gerenteEmergenciaBinding(TopicExchange topicExchange, Queue gerenteQueue) {
		return BindingBuilder.bind(gerenteQueue).to(topicExchange).with("hotel.emergencia");
	}

	// Binding para Auditoria (Backlog - recebe tudo)
	@Bean
	public Binding auditoriaBinding(TopicExchange topicExchange, Queue auditoriaQueue) {
		return BindingBuilder.bind(auditoriaQueue).to(topicExchange).with("hotel.#");
	}
}
