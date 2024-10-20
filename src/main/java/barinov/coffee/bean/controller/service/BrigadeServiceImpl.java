package barinov.coffee.bean.controller.service;

import barinov.coffee.bean.controller.model.Brigade;
import barinov.coffee.bean.controller.repository.BrigadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BrigadeServiceImpl implements BrigadeService{

    private final BrigadeRepository brigadeRepository;

    @Autowired
    public BrigadeServiceImpl(BrigadeRepository brigadeRepository) {
        this.brigadeRepository = brigadeRepository;
    }

    @Override
    @Transactional
    public Brigade saveBrigadeIfNotExist(String brigadeUuid) {
        Brigade brigade = new Brigade();

        brigade.setStringUuid(brigadeUuid);

        return brigadeRepository.save(brigade);
    }
}
