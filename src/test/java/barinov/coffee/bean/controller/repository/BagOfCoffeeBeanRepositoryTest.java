package barinov.coffee.bean.controller.repository;

import barinov.coffee.bean.controller.model.BagOfCoffeeBean;
import jakarta.persistence.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class BagOfCoffeeBeanRepositoryTest {
    @Autowired
    private BagOfCoffeeBeanRepository bagRepository;
    private BagOfCoffeeBean bag;

    @BeforeEach
    public void setUp() {
        BagOfCoffeeBean bagOfCoffeeBean = new BagOfCoffeeBean(0, "Russia", 50, 50, "TestVariety", null);
        bag = bagRepository.save(bagOfCoffeeBean);
    }

    @Test
    @DirtiesContext
    public void getRemainingCoffeeBeanByFiltersTest() {
        List<Tuple> tuples = bagRepository.getRemainingCoffeeBeanByFilters(bag.getVariety(), bag.getCountry());

        Tuple tuple = tuples.get(0);

        assertEquals(tuple.get(0, Long.class), 1L);
        assertEquals(tuple.get(1, String.class), bag.getVariety());
        assertEquals(tuple.get(2, String.class), bag.getCountry());
    }
}
