package barinov.coffee.bean.controller.service;

import barinov.coffee.bean.controller.dto.BrigadeLossDTO;
import barinov.coffee.bean.controller.dto.CountryLossDTO;
import barinov.coffee.bean.controller.dto.RemainingCoffeeBeansViewDTO;
import barinov.coffee.bean.controller.model.BagOfCoffeeBean;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RESTServiceImpl implements RESTService{

    private final BagOfCoffeeBeanService bagService;
    private final RoastingService roastingService;

    private final int DECIMAL_PLACES = 2;

    @Autowired
    public RESTServiceImpl(BagOfCoffeeBeanService bagService, RoastingService roastingService) {
        this.bagService = bagService;
        this.roastingService = roastingService;
    }

    @Override
    public List<RemainingCoffeeBeansViewDTO> getRemains(String variety, String country) {
        List<Tuple> tuples = bagService.getRemainingCoffeeBeanByFilters(variety, country);

        return tuples.stream()
                .map(tuple -> new RemainingCoffeeBeansViewDTO(
                        tuple.get(0, Long.class).intValue(),
                        tuple.get(1, String.class),
                        tuple.get(2, String.class)))
                .collect(Collectors.toList());
    }

    @Override
    public List<BrigadeLossDTO> getAllBrigadeLoss() {
        List<Tuple> tuples = roastingService.getAllBrigadeRoastingMainInf();

        return tuples.stream()
                .map(this::convertTupleToBrigadeLossDTO).collect(Collectors.toList());
    }

    @Override
    public BrigadeLossDTO getBrigadeLossByUuid(String uuid) {
        Tuple tuple = roastingService.getBrigadeRoastingMainInfByUuid(uuid);

        return convertTupleToBrigadeLossDTO(tuple);
    }

    @Override
    public List<CountryLossDTO> getAllCountryLoss() {
        List<Tuple> tuples = roastingService.getAllCountryRoastingMainInf();

        return tuples.stream()
                .map(this::convertTupleToCountryLossDTO).collect(Collectors.toList());
    }

    @Override
    public CountryLossDTO getCountryLossByCountryName(String country) {
        Tuple tuple = roastingService.getCountryMainInfByCountryName(country);

        return convertTupleToCountryLossDTO(tuple);
    }

    public double calculatePercentageOfLoss(Long countOfBags, int outputWeight, int bagWeight) {
        double expectedWeight = countOfBags.intValue() * bagWeight;
        double result = (expectedWeight - outputWeight) / expectedWeight * 100;
        double count = Math.pow(10, DECIMAL_PLACES);

        return Math.round(result * count) / count;
    }

    public BrigadeLossDTO convertTupleToBrigadeLossDTO(Tuple tuple) {
        return new BrigadeLossDTO(
                tuple.get(0, UUID.class).toString(),
                calculatePercentageOfLoss(tuple.get(1, Long.class), tuple.get(2, Integer.class), BagOfCoffeeBean.WEIGHT)
        );
    }

    public CountryLossDTO convertTupleToCountryLossDTO(Tuple tuple) {
        return new CountryLossDTO(
                tuple.get(0, String.class),
                calculatePercentageOfLoss(tuple.get(1, Long.class), tuple.get(2, Integer.class), BagOfCoffeeBean.WEIGHT)
        );
    }
}
