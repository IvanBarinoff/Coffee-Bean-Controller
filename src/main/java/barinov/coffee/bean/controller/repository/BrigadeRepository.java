package barinov.coffee.bean.controller.repository;

import barinov.coffee.bean.controller.model.Brigade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrigadeRepository extends JpaRepository<Brigade, UUID> {

}
