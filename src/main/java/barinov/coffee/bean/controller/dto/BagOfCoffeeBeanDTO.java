package barinov.coffee.bean.controller.dto;

public class BagOfCoffeeBeanDTO {
    private String country;
    private double percentageOfRobusta;
    private double percentageOfArabica;
    private String variety;

    public BagOfCoffeeBeanDTO(String country, double percentageOfRobusta, double percentageOfArabica, String variety) {
        this.country = country;
        this.percentageOfRobusta = percentageOfRobusta;
        this.percentageOfArabica = percentageOfArabica;
        this.variety = variety;
    }

    public BagOfCoffeeBeanDTO() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPercentageOfRobusta() {
        return percentageOfRobusta;
    }

    public void setPercentageOfRobusta(double percentageOfRobusta) {
        this.percentageOfRobusta = percentageOfRobusta;
    }

    public double getPercentageOfArabica() {
        return percentageOfArabica;
    }

    public void setPercentageOfArabica(double percentageOfArabica) {
        this.percentageOfArabica = percentageOfArabica;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}
