package PlanetBook.Repository;

import PlanetBook.Entity.LikePlanet;
import PlanetBook.Entity.LikeStar;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MICHAL on 18.3.2017.
 */
@Repository
public interface LikeStarRepository extends CrudRepository<LikeStar, Long> {
    @Query("SELECT ls FROM LikeStar ls WHERE ls.ip = :ip AND ls.objectid = :objid")
    List<LikeStar> find(@Param("ip") String ip, @Param("objid") Long objid);
}