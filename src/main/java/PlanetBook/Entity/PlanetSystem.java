package PlanetBook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.collections.ObservableSet;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by MICHAL on 12.3.2017.
 */

@Entity
@Table(name = "system")
public class PlanetSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.INSERT)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String descr;


    @OneToMany(mappedBy="systemPlanet", cascade=CascadeType.ALL)
    private Set<Star> Stars;

    @OneToMany(mappedBy="systemPlanet")
    private Set<Planet> Planets;


    protected PlanetSystem() {
    }

    public PlanetSystem(String Name, ArrayList<Star> stars, ArrayList<Planet> planets) {
        this.name = Name;
        Stars = new HashSet<Star>();
        Stars.addAll(stars);
        Planets = new HashSet<Planet>();
        Planets.addAll(planets);
        //star.setSystem(this);
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

    public Set<PlanetBook.Entity.Star> getStars() {
        return Stars;
    }

    public Set<Planet> getPlanets()
    {
        return Planets;
    }

    @Column(name = "likes")
    private int Likes;

    public int getLikes()
    {
        return Likes;
    }
}
