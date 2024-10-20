package barinov.coffee.bean.controller.repository;

import barinov.coffee.bean.controller.model.BagOfCoffeeBean;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BagOfCoffeeBeanRepository extends JpaRepository<BagOfCoffeeBean, Integer>, BagOfCoffeeBeanCustomRepository {

    List<BagOfCoffeeBean> findAllByVarietyAndCountryAndBrigadeNull(String variety, String country, Pageable pageable);
}

