package com.example.gokul.Quizapp.models;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

@Entity
@Table(name="roles")
@ToString
public class SecurityRoles implements GrantedAuthority {
    @Id
    @Column(name="Role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer roleId;
    @Column(name="Roles")
    String Authority;

    public SecurityRoles(Integer roleId, String Authority) {
        this.roleId = roleId;
        this.Authority = Authority;    
    }
    public SecurityRoles() {
        super();
    }
    public Integer getRoleId() {
        return roleId;
    }
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    
    @Override
    public String getAuthority() {
  
        return this.Authority;
    }

    public void setAuthority(String Authority){
        this.Authority= Authority;
    }

}
