package PlanetBook.Controller;

import PlanetBook.Entity.*;
import PlanetBook.Repository.LikeStarRepository;
import PlanetBook.Repository.StarRepository;
import PlanetBook.Utils.HibernateUtil;
import PlanetBook.Utils.ServerUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MICHAL on 18.3.2017.
 */
@RestController
public class StarController {

    @Autowired(required = true)
    StarRepository repository;

    @Autowired(required = true)
    LikeStarRepository likeRepository;

    @RequestMapping("/stars")
    public List<Star> getStars() {
        List<Star> list = new ArrayList<Star>();

        for (Star star : repository.findAll()) {
            list.add(star);
        }
        return list;
    }

    @RequestMapping("stars/like")
    public ResultState like(@RequestParam("id") Long id, HttpServletRequest request){
        Session session=null;
        String ip = ServerUtils.getClientIpAddress(request);
        int like = -1;

        try
        {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();

            Star st = repository.findOne(id);

            if (st == null)
            {
                return new ResultState(true, ip, "Neznámá hvězda",-1);
            }


            List<LikeStar> planets = likeRepository.find(ip, st.getId());
            if (planets.size() > 0) {
                return new ResultState(true, ip, "Hvězda již byla označena - Likem",-1);
            }

            // must have in transaction
            LikeStar l = new LikeStar(ip, st.getSystem_id());
            likeRepository.save(l);

            like = st.getLikes()+1;
            st.setLikes(like);
            repository.save(st);

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
