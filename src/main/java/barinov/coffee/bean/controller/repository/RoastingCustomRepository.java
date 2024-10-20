package barinov.coffee.bean.controller.repository;

import jakarta.persistence.Tuple;

import java.util.List;

public interface RoastingCustomRepository {
    List<Tuple> getAllBrigadeRoastingMainInf();

    Tuple getBrigadeRoastingMainInfByUuid(String uuid);

    List<Tuple> getAllCountryRoastingMainInf();

    Tuple getCountryRoastingMainInfByCountryName(String country);
}
