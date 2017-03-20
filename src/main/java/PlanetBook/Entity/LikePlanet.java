package PlanetBook.Entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

/**
 * Created by MICHAL on 16.3.2017.
 */
@Entity
@Table(name="likeplanet")
public class LikePlanet {

    public LikePlanet()
    {

    }

    public LikePlanet(String ip, long id)
    {
        this.ip = ip;
        this.objectid = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.INSERT)
    @Column(name = "id")
    private long id;

    @Column(name="ip")
    private String ip;

    @Column(name="planetid")
    private long objectid;

    public String getIp()
    {
        return ip;
    }

    public long getObjectid()
    {
        return objectid;
    }

    public long getId()
    {
        return id;
    }
}
