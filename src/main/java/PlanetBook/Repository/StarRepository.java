package PlanetBook.Repository;

import PlanetBook.Entity.Planet;
import PlanetBook.Entity.PlanetSystem;
import PlanetBook.Entity.Star;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by MICHAL on 18.3.2017.
 */
public interface StarRepository extends CrudRepository<Star, Long> {
    List<Star> findByName(String name);
}