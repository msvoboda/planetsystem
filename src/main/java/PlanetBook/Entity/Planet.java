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
public class Planet implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Generated(GenerationTime.INSERT)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String descr;

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

    public long getSystem_id() {
        return system_id;
    }



    protected Planet() {
    }

    public Planet(String Name, String sys) {
        this.name = Name;
        //this.system = sys;
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
