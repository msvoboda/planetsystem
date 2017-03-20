package PlanetBook.Controller;

/**
 * Created by MICHAL on 10.3.2017.
 */
import PlanetBook.Entity.Planet;
import PlanetBook.Entity.PlanetSystem;
import PlanetBook.Entity.Star;
import PlanetBook.PlanetRepository;
import PlanetBook.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlanetsController {

    /*
    @Inject
    public HelloController(PlanetRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @Autowired(required = true)
    PlanetRepository repository;
    @Autowired(required = true)
    SystemRepository sysrepository;

    @RequestMapping("/")
    public String index() {
        return "PlanetBook 1.0";
    }


    @RequestMapping("/initialize")
    public String init() {

        Star star = new Star("sun");
        sysrepository.save(new PlanetSystem("solar", star));
/*
        repository.save(new Planet("Merkur", "solar"));
        repository.save(new Planet("Venuše", "solar"));
        repository.save(new Planet("Země", "solar"));
        repository.save(new Planet("Mars", "solar"));
        repository.save(new Planet("Jupiter", "solar"));
        repository.save(new Planet("Saturn", "solar"));
        repository.save(new Planet("Uran", "solar"));
        repository.save(new Planet("Neptun", "solar"));
*/
        return "Done";
    }

    @RequestMapping("/save")
    public String process(){
        repository.save(new Planet("Jack", "Smith"));
        return "Done";
    }

    @RequestMapping("/planets")
    public List<Planet> findAll() {
        List<Planet> list = new ArrayList<Planet>();

        for (Planet pl : repository.findAll()) {
            list.add(pl);
        }
        return list;
    }

    @RequestMapping("/systems")
    public List<PlanetSystem> getSystems() {
        List<PlanetSystem> list = new ArrayList<PlanetSystem>();

        for (PlanetSystem pl : sysrepository.findAll()) {
            list.add(pl);
        }
        return list;
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = repository.findOne(id).toString();
        return result;
    }

    /*
    @RequestMapping("/findbylastname")
    public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
        String result = "<html>";

        for (Planet cust : repository.findByName(lastName)) {

        }

        return result;
    }
    */
}
