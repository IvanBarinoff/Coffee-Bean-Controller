package barinov.coffee.bean.controller.service;

import barinov.coffee.bean.controller.dto.BagOfCoffeeBeanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final BagOfCoffeeBeanService bagService;

    @Autowired
    public KafkaConsumerService(BagOfCoffeeBeanService bagService) {
        this.bagService = bagService;
    }

    @KafkaListener(topics = "DeliveryOfBag", groupId = "group_id",
            containerFactory = "concurrentKafkaListenerContainerFactory")
    public void listen(@Payload BagOfCoffeeBeanDTO bag) {
        bagService.add(bag);
    }
}
