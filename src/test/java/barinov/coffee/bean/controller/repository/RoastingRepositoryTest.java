package barinov.coffee.bean.controller.repository;

import barinov.coffee.bean.controller.model.BagOfCoffeeBean;
import barinov.coffee.bean.controller.model.Brigade;
import barinov.coffee.bean.controller.model.Roasting;
import jakarta.persistence.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RoastingRepositoryTest {

    @Autowired
    private BagOfCoffeeBeanRepository bagRepository;

    @Autowired
    private BrigadeRepository brigadeRepository;

    @Autowired
    private RoastingRepository roastingRepository;

    private Brigade brigade;
    private BagOfCoffeeBean bag;
    private Roasting roasting;

    @BeforeEach
    public void setUp() {
        Brigade brigadeLocal = new Brigade(UUID.randomUUID());
        brigade = brigadeRepository.save(brigadeLocal);

        BagOfCoffeeBean bagOfCoffeeBean = new BagOfCoffeeBean(0, "Russia", 50, 50, "TestVariety", brigade);
        bag = bagRepository.save(bagOfCoffeeBean);

        Roasting roastingLocal = new Roasting(0, brigade, 1, "Russia", "TestVariety", 48000);
        roasting = roastingRepository.save(roastingLocal);
    }

    @Test
    @DirtiesContext
    public void getAllBrigadeRoastingMainInfTest() {
        List<Tuple> tuples = roastingRepository.getAllBrigadeRoastingMainInf();

        Tuple tuple = tuples.get(0);

        assertEquals(tuple.get(0, UUID.class), brigade.getUuid());
        assertEquals(tuple.get(1, Long.class), 1L);
        assertEquals(tuple.get(2, Integer.class), roasting.getOutputWeight());
    }

    @Test
    @DirtiesContext
    public void getBrigadeLossByUuidTest() {
        Tuple tuple = roastingRepository.getBrigadeRoastingMainInfByUuid(brigade.getUuid().toString());

        assertEquals(tuple.get(0, UUID.class), brigade.getUuid());
        assertEquals(tuple.get(1, Long.class), 1L);
        assertEquals(tuple.get(2, Integer.class), roasting.getOutputWeight());
    }

    @Test
    @DirtiesContext
    public void getAllCountryLossTest() {
        List<Tuple> tuples = roastingRepository.getAllCountryRoastingMainInf();

        Tuple tuple = tuples.get(0);

        assertEquals(tuple.get(0, String.class), bag.getCountry());
        assertEquals(tuple.get(1, Long.class), 1L);
        assertEquals(tuple.get(2, Integer.class), roasting.getOutputWeight());
    }

    @Test
    @DirtiesContext
    public void getCountryLossByCountryName() {
        Tuple tuple = roastingRepository.getCountryRoastingMainInfByCountryName(bag.getCountry());

        assertEquals(tuple.get(0, String.class), bag.getCountry());
        assertEquals(tuple.get(1, Long.class), 1L);
        assertEquals(tuple.get(2, Integer.class), roasting.getOutputWeight());
    }
}
