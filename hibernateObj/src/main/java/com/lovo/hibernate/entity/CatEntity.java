package com.lovo.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_cat")
public class CatEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long catId;
  @Column(length = 48)
   private  String catName;
  @ManyToMany(mappedBy = "cats")
  private Set<PersonEntity> personEntitySet;

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Set<PersonEntity> getPersonEntitySet() {
        return personEntitySet;
    }

    public void setPersonEntitySet(Set<PersonEntity> personEntitySet) {
        this.personEntitySet = personEntitySet;
    }
}
