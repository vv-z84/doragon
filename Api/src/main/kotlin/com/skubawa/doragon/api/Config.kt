package com.skubawa.doragon.api

import com.rabbitmq.client.Connection
import com.rabbitmq.client.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {
    @Bean(destroyMethod = "close")
    fun createConnection(): Connection {
        val factory = ConnectionFactory()

        return factory.newConnection()
    }
}