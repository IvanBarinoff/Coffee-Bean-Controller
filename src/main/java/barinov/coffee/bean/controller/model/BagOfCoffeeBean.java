package barinov.coffee.bean.controller.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bags")
public class BagOfCoffeeBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "weight")
    public static final int WEIGHT = 60_000;

    private String country;

    @Column(name = "percentage_of_robusta")
    private double percentageOfRobusta;

    @Column(name = "percentage_of_arabica")
    private double percentageOfArabica;

    private String variety;

    @ManyToOne
    @JoinColumn(name = "brigade_uuid")
    private Brigade brigade;

    public BagOfCoffeeBean() {
    }

    public BagOfCoffeeBean(int id, String country, double percentageOfRobusta, double percentageOfArabica, String variety, Brigade brigade) {
        this.id = id;
        this.country = country;
        this.percentageOfRobusta = percentageOfRobusta;
        this.percentageOfArabica = percentageOfArabica;
        this.variety = variety;
        this.brigade = brigade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }
}
