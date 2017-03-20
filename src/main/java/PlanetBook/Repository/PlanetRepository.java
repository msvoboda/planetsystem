package PlanetBook.Repository;

import PlanetBook.Entity.Planet;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MICHAL on 13.3.2017.
 */
@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long>{
    List<Planet> findByName(String name);
}