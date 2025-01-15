package com.skubawa.doragon.api.http.queue

import com.rabbitmq.client.Connection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class QueuesController {
    @Autowired()
    lateinit var connection: Connection

    @PostMapping("/enqueue")
    fun enqueue(@RequestBody requestBody: EnqueueRequestBody) {
        val channel = connection.createChannel()
        val queueName = "doragon_tasks"
        val isDurable = true
        val isExclusive = false
        val shouldAutoDelete = false
        val exchangeName = "doragon_tasks_exchange"
        val routingKey = queueName

        channel.exchangeDeclare(exchangeName, "direct", true)
        channel.queueDeclare(queueName, isDurable, isExclusive, shouldAutoDelete, null)

        channel.queueBind(queueName, exchangeName, routingKey)

        val body = requestBody.toString().toByteArray()

        channel.basicPublish(exchangeName, routingKey, null, body)
        channel.close()
    }
}