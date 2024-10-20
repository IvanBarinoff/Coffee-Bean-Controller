package barinov.coffee.bean.controller.repository;

import barinov.coffee.bean.controller.model.Roasting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoastingRepository extends JpaRepository<Roasting, Integer>, RoastingCustomRepository {
}
