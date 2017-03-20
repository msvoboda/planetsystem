package PlanetBook.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
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
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String descr;


    @OneToOne(mappedBy="systemPlanet", cascade=CascadeType.ALL)
    private Star Star;

    @OneToMany(mappedBy="systemPlanet")
    private Set<Planet> Planets;


    protected PlanetSystem() {
    }

    public PlanetSystem(String Name, Star star) {
        this.name = Name;
        Star = star;
        star.setSystem(this);
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

    public PlanetBook.Entity.Star getStar() {
        return Star;
    }

    public Set<Planet> getPlanets()
    {
        return Planets;
    }
}
