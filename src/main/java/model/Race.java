package model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "team_name")
//    private String teamName;

    @Column(name = "race_date")
    private Date raceDate;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "race")
    private Set<Team> teamsList = new HashSet<Team>();

    public Race(){}

    public Race(Date raceDate, String location) {
        this.raceDate = raceDate;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public void setId(long id) {
        this.id = id;
    }
}
