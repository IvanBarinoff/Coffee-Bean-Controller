package barinov.coffee.bean.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO для отображения потерь зерна страны")
public class CountryLossDTO {

    @Schema(description = "Название страны")
    private String country;

    @Schema(description = "Процент потери зерна")
    private double percentageOfLoss;

    public CountryLossDTO() {
    }

    public CountryLossDTO(String country, double percentageOfLoss) {
        this.country = country;
        this.percentageOfLoss = percentageOfLoss;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPercentageOfLoss() {
        return percentageOfLoss;
    }

    public void setPercentageOfLoss(double percentageOfLoss) {
        this.percentageOfLoss = percentageOfLoss;
    }
}
