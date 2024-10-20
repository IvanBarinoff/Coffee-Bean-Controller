package barinov.coffee.bean.controller.repository;

import jakarta.persistence.Tuple;

import java.util.List;

public interface BagOfCoffeeBeanCustomRepository {
    List<Tuple> getRemainingCoffeeBeanByFilters(String variety, String country);
}
