package barinov.coffee.bean.controller.controller;

import barinov.coffee.bean.controller.dto.BrigadeLossDTO;
import barinov.coffee.bean.controller.dto.CountryLossDTO;
import barinov.coffee.bean.controller.dto.RemainingCoffeeBeansViewDTO;
import barinov.coffee.bean.controller.service.RESTService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="Контроллер для вывода информации о зерне",
        description="Позволяет узнать основную информацию об остатках и потерях зерна.")
@RestController
public class RESTController {

    private final RESTService restService;

    @Autowired
    public RESTController(RESTService restService) {
        this.restService = restService;
    }

    @Operation(
            summary = "Получение информации о количестве остатков зерна по каждому сорту и стране",
            description = "Для получения информации о количестве остатков зерна отдельного сорта необходимо заполнить параметр variety." +
                    "Для получения информации о количестве остатков зерна отдельной страны необходимо заполнить параметр county."
    )
    @GetMapping("/remains")
    public List<RemainingCoffeeBeansViewDTO> getRemains(@RequestParam(value = "variety", required = false) @Parameter(description = "Сорт") String variety,
                                                        @RequestParam(value = "country", required = false) @Parameter(description = "Страна") String county) {

        return restService.getRemains(variety, county);
    }

    @Operation(summary = "Получение информации о потерях зерна при обжарке для каждой бригады")
    @GetMapping("/loss/brigade")

    public List<BrigadeLossDTO> getBrigadeLoss() {
        return restService.getAllBrigadeLoss();
    }

    @Operation(summary = "Получение информации о потерях зерна при обжарке для отдельной бригады")
    @GetMapping("/loss/brigade/{brigadeUuid}")
    public BrigadeLossDTO getBrigadeLossByUuid(@PathVariable("brigadeUuid") @Parameter(description = "UUID бригады") String uuid) {
        return restService.getBrigadeLossByUuid(uuid);
    }

    @Operation(summary = "Получение информации о потерях зерна при обжарке для каждой страны")
    @GetMapping("/loss/country")
    public List<CountryLossDTO> getCountryLoss() {
        return restService.getAllCountryLoss();
    }

    @Operation(summary = "Получение информации о потерях зерна при обжарке для отдельной страны")
    @GetMapping("/loss/country/{country}")
    public CountryLossDTO getCountryLoss(@PathVariable("country") @Parameter(description = "Название страны") String country) {
        return restService.getCountryLossByCountryName(country);
    }
}
