package PlanetBook.Repository;

import PlanetBook.Entity.LikePlanet;
import PlanetBook.Entity.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MICHAL on 16.3.2017.
 */
@Repository
public interface LikePlanetRepository extends CrudRepository<LikePlanet, Long> {

    @Query("SELECT lp FROM LikePlanet lp WHERE lp.ip = :ip AND lp.objectid = :objid")
    List<LikePlanet> find(@Param("ip") String ip, @Param("objid") Long objid);
}