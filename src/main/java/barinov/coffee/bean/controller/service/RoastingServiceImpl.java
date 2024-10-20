package barinov.coffee.bean.controller.service;

import barinov.coffee.bean.controller.model.Roasting;
import barinov.coffee.bean.controller.repository.RoastingRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoastingServiceImpl implements RoastingService{

    private final RoastingRepository roastingRepository;

    @Autowired
    public RoastingServiceImpl(RoastingRepository roastingRepository) {
        this.roastingRepository = roastingRepository;
    }

    @Override
    @Transactional
    public Roasting add(Roasting roasting) {
        return roastingRepository.save(roasting);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tuple> getAllBrigadeRoastingMainInf() {
        return roastingRepository.getAllBrigadeRoastingMainInf();
    }

    @Override
    @Transactional(readOnly = true)
    public Tuple getBrigadeRoastingMainInfByUuid(String uuid) {
        return roastingRepository.getBrigadeRoastingMainInfByUuid(uuid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tuple> getAllCountryRoastingMainInf() {
        return roastingRepository.getAllCountryRoastingMainInf();
    }

    @Override
    @Transactional(readOnly = true)
    public Tuple getCountryMainInfByCountryName(String country) {
        return roastingRepository.getCountryRoastingMainInfByCountryName(country);
    }
}
