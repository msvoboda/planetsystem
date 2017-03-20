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
public class Star extends PlanetObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.INSERT)
    @Column(name = "system_id")
    private int system_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String descr;

    protected Star() {
    }

    public Star(String Name) {
        this.name = Name;
    }

    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
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

    public String getName() {
        return name;
    }


    public String getDescr()
    {
        return descr;
    }


}
