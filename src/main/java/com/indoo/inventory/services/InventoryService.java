package com.indoo.inventory.services;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InventoryService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "order-created-topic", groupId = "inventory-service-group")
    public void checkStock(String orderData) {
        System.out.println("Check stock: " + orderData);
        // Check stock availability for the order
        boolean stockAvailable = checkStockAvailability(orderData);

        if (stockAvailable) {
            kafkaTemplate.send("stock-reserved-topic", orderData);
        } else {
            kafkaTemplate.send("stock-unavailable-topic", orderData);
        }
    }

    private boolean checkStockAvailability(String orderData) {
        return true;
    }
}
