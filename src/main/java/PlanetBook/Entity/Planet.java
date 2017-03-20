package PlanetBook.Entity;

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

    @Column(name = "system")
    private String system;

    @Column(name = "description")
    private String descr;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "system_id", referencedColumnName = "id")
    private PlanetSystem System;

    protected Planet() {
    }

    public Planet(String Name, String sys) {
        this.name = Name;
        this.system = sys;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSystem()
    {
        return system;
    }

    public String getDescr()
    {
        return descr;
    }

}
