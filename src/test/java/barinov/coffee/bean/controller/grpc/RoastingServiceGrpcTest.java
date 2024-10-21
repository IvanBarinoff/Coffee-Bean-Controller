package barinov.coffee.bean.controller.grpc;

import barinov.coffee.bean.controller.service.*;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(properties = {
        "grpc.server.port=8100"
},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoastingServiceGrpcTest {

    @MockBean
    private BagOfCoffeeBeanService bagService;

    @MockBean
    private BrigadeService brigadeService;

    @MockBean
    private RoastingServiceImpl roastingService;

    @Autowired
    private RoastingServiceGrpcImpl roastingServiceGrpc;

    File.Roasting roasting;

    @BeforeEach
    public void setUp() {
        roasting = File.Roasting.newBuilder()
                .setCountOfBags(1)
                .setCountry("Russia")
                .setBrigadeUUID("25fc15c3-de63-4536-b651-f3c33a8c408a")
                .setOutputWeight(48500)
                .setVariety("testVariety")
                .build();

        roastingServiceGrpc.messageRoasting(roasting, Mockito.mock(StreamObserver.class));
    }

    @Test
    public void callChangeBagsTest() {
        Mockito.verify(bagService).changeBags(Mockito.anyList());
    }

    @Test
    public void callSaveBrigadeIfNotExistTest() {
        Mockito.verify(brigadeService).saveBrigadeIfNotExist(roasting.getBrigadeUUID());
    }

    @Test
    public void callGetUnroastedBagsByVarietyAndCountryTest() {
        Mockito.verify(bagService).getUnroastedBagsByVarietyAndCountry(
                roasting.getCountOfBags(), roasting.getVariety(), roasting.getCountry());
    }

    @Test
    public void callAddTest() {
        Mockito.verify(roastingService).add(Mockito.any());
    }
}
