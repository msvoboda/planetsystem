package PlanetBook.Entity;

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
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String descr;

    @OneToMany(mappedBy="System")
    private Set<Planet> planets;

    @OneToOne(mappedBy="System", cascade=CascadeType.ALL)
    private Star star;

    protected PlanetSystem() {
    }

    public PlanetSystem(String Name) {
        this.name = Name;
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
}
