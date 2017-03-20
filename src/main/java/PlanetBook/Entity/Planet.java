package PlanetBook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MICHAL on 12.3.2017.
 */

@Entity
@Table(name = "planet")
public class Planet extends  PlanetObject{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.INSERT)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String descr;

    @Column(name="image")
    private String image;

    @Column(name = "likes", nullable = false, columnDefinition = "int default 0")
    private int Likes;

    @Column(name = "system_id", insertable = false, updatable = false)
    private int system_id;

    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "system_id", referencedColumnName = "id")
    private PlanetSystem systemPlanet;

    public void setSystem(PlanetSystem sys)
    {
        systemPlanet = sys;
    }

    @JsonIgnore
    public PlanetSystem getSystem()
    {
        return systemPlanet;
    }

    @JsonIgnore
    public long getSystem_id() {
        return system_id;
    }



    protected Planet() {
    }

    public Planet(String Name, String desc) {
        this.name = Name;
        this.descr = desc;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescr()
    {
        return descr;
    }

    public String getImage() {return image;}

    public int getLikes()
    {
        return Likes;
    }

    public void setLikes(int set)
    {
      Likes = set;
    }

}
