package barinov.coffee.bean.controller.service;

import barinov.coffee.bean.controller.dto.BrigadeLossDTO;
import barinov.coffee.bean.controller.dto.CountryLossDTO;
import barinov.coffee.bean.controller.dto.RemainingCoffeeBeansViewDTO;

import java.util.List;

public interface RESTService {

    List<RemainingCoffeeBeansViewDTO> getRemains(String variety, String country);

    List<BrigadeLossDTO> getAllBrigadeLoss();

    BrigadeLossDTO getBrigadeLossByUuid(String uuid);

    List<CountryLossDTO> getAllCountryLoss();

    CountryLossDTO getCountryLossByCountryName(String country);
}
