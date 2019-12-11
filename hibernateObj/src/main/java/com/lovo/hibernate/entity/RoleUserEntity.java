package com.lovo.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "sys_role_user")
public class RoleUserEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ru_id")
    private long roleUserId;
    private int tag=0;//标志，0为正常，1为冻结
    @ManyToOne
    @JoinColumn(name = "r_id")
    private  RoleEntity role;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private  UserEntity user;

    public long getRoleUserId() {
        return roleUserId;
    }

    public void setRoleUserId(long roleUserId) {
        this.roleUserId = roleUserId;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
