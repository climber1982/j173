package com.lovo.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_power")
public class PowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private long powerId;
    @Column(length = 48)
    private  String powerName;
    @Column(length = 128)
    private  String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getPowerId() {
        return powerId;
    }

    public void setPowerId(long powerId) {
        this.powerId = powerId;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }
}
