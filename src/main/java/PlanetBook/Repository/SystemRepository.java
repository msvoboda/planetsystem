package PlanetBook.Repository;

import PlanetBook.Entity.Planet;
import PlanetBook.Entity.PlanetSystem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MICHAL on 15.3.2017.
 */
@Repository
public interface SystemRepository extends CrudRepository<PlanetSystem, Long> {
    List<PlanetSystem> findByName(String name);
    List<PlanetSystem> findByDescr(String descr);
}
