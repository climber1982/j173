package com.lovo.spring.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_cat", schema = "j173", catalog = "")
public class TCatEntity {
    private long catId;
    private String catName;

    @Id
    @Column(name = "catId")
    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    @Basic
    @Column(name = "catName")
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TCatEntity that = (TCatEntity) o;
        return catId == that.catId &&
                Objects.equals(catName, that.catName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catId, catName);
    }
}
