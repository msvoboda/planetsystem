package PlanetBook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

/**
 * Created by MICHAL on 12.3.2017.
 */

@Entity
@Table(name = "star")
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.INSERT)
    @Column(name = "id")
    private Long id;

    @Column(name = "system_id", insertable = false, updatable = false)
    private Long system_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String descr;

    protected Star() {
    }

    public Star(String Name) {
        this.name = Name;
    }

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

    public long getSystem_id() {
        return system_id;
    }

    public long getId() {return id;}

    public String getName() {
        return name;
    }


    public String getDescr()
    {
        return descr;
    }

    @Column(name = "likes", nullable = false, columnDefinition = "int default 0")
    private int Likes;

    public int getLikes()
    {
        return Likes;
    }

    public void setLikes(int set)
    {
        Likes = set;
    }
}
