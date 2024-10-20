package barinov.coffee.bean.controller.kafka;

import barinov.coffee.bean.controller.dto.BagOfCoffeeBeanDTO;
import barinov.coffee.bean.controller.service.BagOfCoffeeBeanService;
import barinov.coffee.bean.controller.service.KafkaConsumerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
public class KafkaConsumerServiceTest {
    @MockBean
    private BagOfCoffeeBeanService bagService;

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @Test
    public void listenTest() {
        kafkaConsumerService.listen(Mockito.mock(BagOfCoffeeBeanDTO.class));

        Mockito.verify(bagService).add(Mockito.any());
    }
}
