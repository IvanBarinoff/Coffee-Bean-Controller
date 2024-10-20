package barinov.coffee.bean.controller.service;

import barinov.coffee.bean.controller.model.Roasting;
import jakarta.persistence.Tuple;

import java.util.List;

public interface RoastingService {

    Roasting add(Roasting roasting);

    List<Tuple> getAllBrigadeRoastingMainInf();

    Tuple getBrigadeRoastingMainInfByUuid(String uuid);

    List<Tuple> getAllCountryRoastingMainInf();

    Tuple getCountryMainInfByCountryName(String country);
}
