package barinov.coffee.bean.controller.service;

import barinov.coffee.bean.controller.dto.BagOfCoffeeBeanDTO;
import barinov.coffee.bean.controller.model.BagOfCoffeeBean;
import barinov.coffee.bean.controller.repository.BagOfCoffeeBeanRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BagOfCoffeeBeanServiceImpl implements BagOfCoffeeBeanService {

    private final BagOfCoffeeBeanRepository bagRepository;
    private final ModelMapper mapper;

    @Autowired
    public BagOfCoffeeBeanServiceImpl(BagOfCoffeeBeanRepository bagRepository, ModelMapper mapper) {
        this.bagRepository = bagRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public BagOfCoffeeBean add(BagOfCoffeeBeanDTO bagDTO) {
        BagOfCoffeeBean bagOfCoffeeBean = mapper.map(bagDTO, BagOfCoffeeBean.class);
        return bagRepository.save(bagOfCoffeeBean);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BagOfCoffeeBean> getUnroastedBagsByVarietyAndCountry(int countOfBags, String variety, String country) {
        return bagRepository.findAllByVarietyAndCountryAndBrigadeNull(variety, country, PageRequest.of(0, countOfBags));
    }

    @Override
    @Transactional
    public void changeBags(List<BagOfCoffeeBean> bags) {
        bagRepository.saveAll(bags);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tuple> getRemainingCoffeeBeanByFilters(String variety, String country) {
        return bagRepository.getRemainingCoffeeBeanByFilters(variety, country);
    }
}
