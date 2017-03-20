package PlanetBook.Controller;

import PlanetBook.Entity.PlanetSystem;
import PlanetBook.Repository.SystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MICHAL on 16.3.2017.
 */

@RestController
public class SystemsController {
    @Autowired(required = true)
    SystemRepository sysrepository;

    @RequestMapping("/systems")
    public List<PlanetSystem> getSystems() {
        List<PlanetSystem> list = new ArrayList<PlanetSystem>();

        for (PlanetSystem pl : sysrepository.findAll()) {
            list.add(pl);
        }
        return list;
    }

    @RequestMapping("systems/findbyid")
    public PlanetSystem findById(@RequestParam("id") long id){
        PlanetSystem result = sysrepository.findOne(id);
        return result;
    }

    @RequestMapping("/systems/findbyname")
    public List<PlanetSystem> findByName(@RequestParam("name") String name) {
        return sysrepository.findByName(name);
    }

}
