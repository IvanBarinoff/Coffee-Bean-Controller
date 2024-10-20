package barinov.coffee.bean.controller.service;

import barinov.coffee.bean.controller.dto.BagOfCoffeeBeanDTO;
import barinov.coffee.bean.controller.model.BagOfCoffeeBean;
import jakarta.persistence.Tuple;

import java.util.List;

public interface BagOfCoffeeBeanService {
    BagOfCoffeeBean add(BagOfCoffeeBeanDTO bag);

    List<BagOfCoffeeBean> getUnroastedBagsByVarietyAndCountry(int countOfBags, String variety, String country);

    void changeBags(List<BagOfCoffeeBean> bags);

    List<Tuple> getRemainingCoffeeBeanByFilters(String variety, String country);
}
