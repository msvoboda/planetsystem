package PlanetBook.Controller;

import PlanetBook.Entity.PlanetObject;
import PlanetBook.Repository.PlanetRepository;
import PlanetBook.Repository.StarRepository;
import PlanetBook.Repository.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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


    public List<PlanetObject> Search(String search)
    {
        return null;
   }
}
