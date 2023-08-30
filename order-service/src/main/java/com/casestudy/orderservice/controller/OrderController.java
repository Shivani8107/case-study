package com.casestudy.orderservice.controller;


import com.casestudy.basedomain.dto.Order;
import com.casestudy.basedomain.dto.OrderEvent;
import com.casestudy.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }
    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        order.setOrderId((UUID.randomUUID().toString()));

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("Pending");
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrder((order));
        orderEvent.setEmail("janhavimudaliar@gmail.com");
        orderEvent.setIsInstantEmail(true);


        orderProducer.sendMessage((orderEvent));

        return "Order Placed successfully";


    }
}
