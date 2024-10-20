package barinov.coffee.bean.controller.controller;

import barinov.coffee.bean.controller.dto.BrigadeLossDTO;
import barinov.coffee.bean.controller.dto.CountryLossDTO;
import barinov.coffee.bean.controller.dto.RemainingCoffeeBeansViewDTO;
import barinov.coffee.bean.controller.service.RESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTController {

    private final RESTService restService;

    @Autowired
    public RESTController(RESTService restService) {
        this.restService = restService;
    }

    @GetMapping("/remains")
    public List<RemainingCoffeeBeansViewDTO> getRemains(@RequestParam(value = "variety", required = false) String variety,
                                                        @RequestParam(value = "country", required = false) String county) {

        return restService.getRemains(variety, county);
    }

    @GetMapping("/loss/brigade")
    public List<BrigadeLossDTO> getBrigadeLoss() {
        return restService.getAllBrigadeLoss();
    }

    @GetMapping("/loss/brigade/{brigadeUuid}")
    public BrigadeLossDTO getBrigadeLossByUuid(@PathVariable("brigadeUuid") String uuid) {
        return restService.getBrigadeLossByUuid(uuid);
    }

    @GetMapping("/loss/country")
    public List<CountryLossDTO> getCountryLoss() {
        return restService.getAllCountryLoss();
    }

    @GetMapping("/loss/country/{country}")
    public CountryLossDTO getCountryLoss(@PathVariable("country") String country) {
        return restService.getCountryLossByCountryName(country);
    }
}
