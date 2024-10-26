package org.example.realss.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "t_roles")
@Data
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String roleName;

    @Transient
    @ManyToMany
    private Set<Person> person;

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
