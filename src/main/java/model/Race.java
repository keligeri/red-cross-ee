package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Race {

    @Id
    @GeneratedValue
    private long id;

}
