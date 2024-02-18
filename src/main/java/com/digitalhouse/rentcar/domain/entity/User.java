package com.digitalhouse.rentcar.domain.entity;


import com.digitalhouse.rentcar.domain.security.SimpleGrantedAuthorityDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "user")
@Table(name = "users")
@JsonIgnoreProperties
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)

    private String surname;


    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @Enumerated
    @Column(length = 50)
    private EnumRole role;

    @JsonDeserialize(contentUsing = SimpleGrantedAuthorityDeserializer.class)
    private List<GrantedAuthority> authorities;



    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<Booking> bookings = new HashSet<>();




    public User(String name, String surname, String email, String password, EnumRole role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == EnumRole.ADMIN) {
            return List.of(EnumRole.ADMIN, EnumRole.USER);
        } else {
            return List.of(EnumRole.USER);
        }
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
