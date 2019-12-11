package com.lovo.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personId;
    @Column(length = 48)
    private String userName;
   @ManyToMany
   @JoinTable(name = "t_person_cat",joinColumns = {@JoinColumn(name = "personId")}
   ,inverseJoinColumns ={@JoinColumn(name = "catId")} )
    Set<CatEntity> cats;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<CatEntity> getCats() {
        return cats;
    }

    public void setCats(Set<CatEntity> cats) {
        this.cats = cats;
    }
}
