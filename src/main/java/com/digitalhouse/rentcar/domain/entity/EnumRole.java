package com.digitalhouse.rentcar.domain.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Getter
@NoArgsConstructor
public enum EnumRole implements GrantedAuthority {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private  String authority;

    EnumRole(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}

