package org.example.realss.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "t_persons")
@Data
@NoArgsConstructor
public class Person implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Size(min = 2, message = "не меньше 2 знаков")
    private String userName;

    @Column
    @Size(min = 2, message = "не меньше 2 знаков")
    private String name;

    @Column
    @Size(min = 2, message = "не меньше 2 знаков")
    private String LastName;

    @Column
    private Byte age;

    @Transient
    private String encodedPassword;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return encodedPassword;
    }

    @Override
    public String getUsername() {
        return userName;
    }
}
