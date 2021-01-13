package com.example.demo;

import java.util.Collection;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements UserDetails
{
    /**
     *
     */
    private static final long serialVersionUID = -6560849368783375225L;

    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    @ElementCollection
    private Map<Product, Integer> cart; 
   
    //UserDetails requires these, they are technically getters (is-ers?) overriden by Lombok.
    // @Transient Makes it so these aren't persisted in the database, as they are hard coded.

    @Transient
    private boolean accountNonExpired = true;
    @Transient
    private boolean accountNonLocked = true;
    @Transient
    private boolean credentialsNonExpired = true;
    @Transient
    private boolean enabled = true;
    @Transient
    private Collection<GrantedAuthority> authorities = null;
}
