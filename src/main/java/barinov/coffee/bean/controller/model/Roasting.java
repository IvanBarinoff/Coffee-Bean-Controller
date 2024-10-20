package barinov.coffee.bean.controller.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roasting")
public class Roasting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "brigade_uuid")
    private Brigade brigade;

    @Column(name = "count_of_bags")
    private int countOfBags;

    private String country;

    private String variety;

    @Column(name = "output_weight")
    private int outputWeight;

    public Roasting(int id, Brigade brigade, int countOfBags, String country, String variety, int outputWeight) {
        this.id = id;
        this.brigade = brigade;
        this.countOfBags = countOfBags;
        this.country = country;
        this.variety = variety;
        this.outputWeight = outputWeight;
    }

    public Roasting() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brigade getBrigade() {
        return brigade;
    }

    public void setBrigade(Brigade brigade) {
        this.brigade = brigade;
    }

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

    public int getOutputWeight() {
        return outputWeight;
    }

    public void setOutputWeight(int outputWeight) {
        this.outputWeight = outputWeight;
    }
}
