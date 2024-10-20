package barinov.coffee.bean.controller.dto;

public class RemainingCoffeeBeansViewDTO {

    private int countOfBags;

    private String variety;
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
