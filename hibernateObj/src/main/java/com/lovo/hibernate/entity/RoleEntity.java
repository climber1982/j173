package com.lovo.hibernate.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sys_role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private long roleId;
    @Column(name = "r_name",length = 48)
    private String roleName;
   @OneToMany(mappedBy = "role")
    private Set<RolePowerEntity> rolePowerSet;
   @OneToMany(mappedBy = "role")
    private Set<RoleUserEntity> roleUserSet;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<RolePowerEntity> getRolePowerSet() {
        return rolePowerSet;
    }

    public void setRolePowerSet(Set<RolePowerEntity> rolePowerSet) {
        this.rolePowerSet = rolePowerSet;
    }

    public Set<RoleUserEntity> getRoleUserSet() {
        return roleUserSet;
    }

    public void setRoleUserSet(Set<RoleUserEntity> roleUserSet) {
        this.roleUserSet = roleUserSet;
    }
}
