package PlanetBook;

import PlanetBook.Entity.Planet;
import PlanetBook.Entity.PlanetSystem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MICHAL on 15.3.2017.
 */
@Repository
public interface SystemRepository extends CrudRepository<PlanetSystem, Long> {
    //List<Planet> findByName(String name);
}
