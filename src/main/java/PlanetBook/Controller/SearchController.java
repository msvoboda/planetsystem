package PlanetBook.Controller;

import PlanetBook.Entity.Planet;
import PlanetBook.Entity.PlanetObject;
import PlanetBook.Entity.PlanetSystem;
import PlanetBook.Entity.Star;
import PlanetBook.Repository.PlanetRepository;
import PlanetBook.Repository.StarRepository;
import PlanetBook.Repository.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MICHAL on 20.3.2017.
 */
@RestController
public class SearchController {


    @Autowired(required = true)
    PlanetRepository repository;

    @Autowired(required = true)
    SystemRepository sysrepository;

    @Autowired(required = true)
    StarRepository sunrepository;

    @RequestMapping("/search")
    public List<PlanetObject> Search(@RequestParam("search") String search) {
        ArrayList<PlanetObject> list = new ArrayList<PlanetObject>();

        for(PlanetSystem sys : sysrepository.findByName(search))
        {
            list.add(sys);
        }

        for(Star st : sunrepository.findByName(search))
        {
            list.add(st);
        }

        for(Planet pl : repository.findByName(search))
        {
            list.add(pl);
        }
        /// description ... rewrite for like
        for(PlanetSystem sys : sysrepository.findByDescr(search))
        {
            list.add(sys);
        }

        for(Star st : sunrepository.findByDescr(search))
        {
            list.add(st);
        }

        for(Planet pl : repository.findByDescr(search))
        {
            list.add(pl);
        }

        return list;

    }

}
