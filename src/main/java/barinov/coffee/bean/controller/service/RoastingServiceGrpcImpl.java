package barinov.coffee.bean.controller.service;

import barinov.coffee.bean.controller.grpc.File;
import barinov.coffee.bean.controller.grpc.RoastingServiceGrpc;
import barinov.coffee.bean.controller.model.BagOfCoffeeBean;
import barinov.coffee.bean.controller.model.Brigade;
import barinov.coffee.bean.controller.model.Roasting;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@GrpcService
public class RoastingServiceGrpcImpl extends RoastingServiceGrpc.RoastingServiceImplBase {

    private final BagOfCoffeeBeanService bagService;
    private final BrigadeService brigadeService;
    private final RoastingService roastingService;

    private final ModelMapper mapper;

    @Autowired
    public RoastingServiceGrpcImpl(BagOfCoffeeBeanService bagService, BrigadeService brigadeService, RoastingService roastingService, ModelMapper mapper) {
        this.bagService = bagService;
        this.brigadeService = brigadeService;
        this.roastingService = roastingService;
        this.mapper = mapper;
    }

    @Override
    public void messageRoasting(File.Roasting roasting, StreamObserver<Empty> responseObserver) {
        List<BagOfCoffeeBean> bags = bagService.getUnroastedBagsByVarietyAndCountry(
                roasting.getCountOfBags(), roasting.getVariety(), roasting.getCountry());

        Brigade brigade = brigadeService.saveBrigadeIfNotExist(roasting.getBrigadeUUID());

        bags.forEach(bag -> bag.setBrigade(brigade));

        bagService.changeBags(bags);

        Roasting roastingModel = mapper.map(roasting, Roasting.class);

        roastingModel.setBrigade(brigade);

        roastingService.add(roastingModel);

        responseObserver.onNext(Empty.getDefaultInstance());
        responseObserver.onCompleted();
    }
}
