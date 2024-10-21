package barinov.coffee.bean.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO для отображения остатков зерна")
public class RemainingCoffeeBeansViewDTO {

    @Schema(description = "Количество мешков")
    private int countOfBags;

    @Schema(description = "Сорт")
    private String variety;

    @Schema(description = "Название страны")
    private String country;

    public RemainingCoffeeBeansViewDTO(int countOfBags, String variety, String country) {
        this.countOfBags = countOfBags;
        this.variety = variety;
        this.country = country;
    }

    public RemainingCoffeeBeansViewDTO() {}

    public int getCountOfBags() {
        return countOfBags;
    }

    public void setCountOfBags(int countOfBags) {
        this.countOfBags = countOfBags;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}
