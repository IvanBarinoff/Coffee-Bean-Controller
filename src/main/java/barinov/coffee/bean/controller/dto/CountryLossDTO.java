package barinov.coffee.bean.controller.dto;

public class CountryLossDTO {

    private String country;

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
