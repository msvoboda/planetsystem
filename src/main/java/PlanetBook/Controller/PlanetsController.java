package PlanetBook.Controller;

/**
 * Created by MICHAL on 10.3.2017.
 */
import PlanetBook.Entity.*;
import PlanetBook.Repository.LikePlanetRepository;
import PlanetBook.Repository.PlanetRepository;
import PlanetBook.Repository.StarRepository;
import PlanetBook.Repository.SystemRepository;
import PlanetBook.Utils.HibernateUtil;
import PlanetBook.Utils.ServerUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class PlanetsController {

    @Autowired(required = true)
    PlanetRepository repository;

    @Autowired(required = true)
    SystemRepository sysrepository;

    @Autowired(required = true)
    StarRepository sunrepository;

    @Autowired(required = true)
    LikePlanetRepository likeRepository;


    @RequestMapping("/")
    public String index() {
        return "PlanetBook 1.0";
    }

    @RequestMapping("/initialize")
    public String init() {
        try {
            Session session=null;
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            Star sun = new Star("Slunce");
            //sunrepository.save(sun);

            ArrayList<Star> stars = new ArrayList<Star>();
            stars.add(sun);

            ArrayList<Planet> planets =  new ArrayList<Planet>();
            planets.add(new Planet("Merkur", ""));
            planets.add(new Planet("Venuše", ""));
            planets.add(new Planet("Země", "Naše zelená planeta"));
            planets.add(new Planet("Mars", "Rudá planeta"));
            planets.add(new Planet("Jupiter", "Planeta s prstenci"));
            planets.add(new Planet("Saturn", ""));
            planets.add(new Planet("Uran", ""));
            planets.add(new Planet("Neptun", ""));

            PlanetSystem system = new PlanetSystem("Sluneční soustava", stars, planets);
            //sysrepository.save(system);
            session.save(system);
            for(int i = 0; i <planets.size();i++)
            {
                planets.get(i).setSystem(system);
                session.save(planets.get(i));
            }
            sun.setSystem(system);
            session.save(sun);
            session.getTransaction().commit();
        }
        catch(Exception ex)
        {

        }
        return "Done";
    }

    @RequestMapping("/save")
    public String process(){
        repository.save(new Planet("LV-452", "ALIENS"));
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

    @RequestMapping("planets/findbyid")
    public Planet findById(@RequestParam("id") long id){
        Planet result = repository.findOne(id);
        return result;
    }


    @RequestMapping("planets/findbyname")
    public List<Planet> findByName(@RequestParam("name") String name){
        List<Planet> result = repository.findByName(name);
        return result;
    }

    @RequestMapping("planets/like")
    public ResultState like(@RequestParam("id") Long id, HttpServletRequest request){
        Session session=null;
        String ip = ServerUtils.getClientIpAddress(request);
        int like = -1;

        try
        {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            Planet pl= repository.findOne(id);

            if (pl == null)
            {
                return new ResultState(true, ip, "Neznámá planeta",-1);
            }


            List<LikePlanet> planets = likeRepository.find(ip, pl.getId());
            if (planets.size() > 0) {
                return new ResultState(true, ip, "Planeta již byla označena - Likem",-1);
            }

            // must have in transaction
            LikePlanet l = new LikePlanet(ip, pl.getId());
            likeRepository.save(l);

            like = pl.getLikes()+1;
            pl.setLikes(like);
            repository.save(pl);

            session.getTransaction().commit();
        }
        catch(Exception ex)
        {
            session.getTransaction().rollback();
            return new ResultState(true, ip, ex.getMessage(),-1);
        }
        finally {
            if (session!=null)
            {
                session.close();
            }
        }

        return new ResultState(false, ip, "Ok", like);
    }
}
