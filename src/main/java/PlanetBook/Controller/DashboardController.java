package PlanetBook.Controller;

import PlanetBook.Entity.Planet;
import PlanetBook.Entity.PlanetObject;
import PlanetBook.Entity.Star;
import PlanetBook.Repository.PlanetRepository;
import PlanetBook.Repository.StarRepository;
import PlanetBook.Repository.SystemRepository;
import javafx.collections.transformation.SortedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.in;

/**
 * Created by MICHAL on 20.3.2017.
 */

@RestController
public class DashboardController {


    @Autowired(required = true)
    PlanetRepository repository;

    @Autowired(required = true)
    SystemRepository sysrepository;

    @Autowired(required = true)
    StarRepository sunrepository;

    @RequestMapping("/dashboard")
    public List<PlanetObject> dashboard(@RequestParam("top") int top)
    {
        List<PlanetObject> sortList = new ArrayList<PlanetObject>();
        for(Planet pl : repository.findAll())
        {
            sortList.add(pl);
        }

        for(Star st : sunrepository.findAll())
        {
            sortList.add(st);
        }

        Collections.sort(sortList, new CustomComparator());
        return sortList.subList(0, top);
    }

    public class CustomComparator implements Comparator<PlanetObject> {
        @Override
        public int compare(PlanetObject object1, PlanetObject object2) {
            return object2.getLikes() - object1.getLikes();
        }

    }

}
