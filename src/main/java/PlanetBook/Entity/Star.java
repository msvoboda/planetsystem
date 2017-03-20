package PlanetBook.Entity;

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
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "system")
    private String system;

    @Column(name = "description")
    private String descr;

    @OneToOne
    @PrimaryKeyJoinColumn
    private PlanetSystem System;

    protected Star() {
    }

    public Star(String Name, String sys) {
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
