package com.lovo.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_role_power")
public class RolePowerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_p_id")
    private  long rolePowerId;
    @ManyToOne
    @JoinColumn(name = "r_id")
    private RoleEntity role;
    @ManyToOne
    @JoinColumn(name = "p_id")
    private  PowerEntity power;

    public long getRolePowerId() {
        return rolePowerId;
    }

    public void setRolePowerId(long rolePowerId) {
        this.rolePowerId = rolePowerId;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public PowerEntity getPower() {
        return power;
    }

    public void setPower(PowerEntity power) {
        this.power = power;
    }
}
