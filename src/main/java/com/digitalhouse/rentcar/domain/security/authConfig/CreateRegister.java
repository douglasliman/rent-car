package com.digitalhouse.rentcar.domain.security.authConfig;

import com.digitalhouse.rentcar.domain.entity.EnumRole;





public record CreateRegister(String name, String surname,String email, String password, EnumRole role) { }
