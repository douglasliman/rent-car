package com.digitalhouse.rentcar.app.api.dto.response.user;

import com.digitalhouse.rentcar.domain.entity.Booking;
import com.digitalhouse.rentcar.domain.entity.EnumRole;
import com.digitalhouse.rentcar.domain.entity.Image;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
@Getter
@Setter
public class UserDetailedResponse {

    private UUID id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private Set<Booking> bookings;

    private EnumRole role;

}
