package com.digitalhouse.rentcar.app.api.dto.response.user;

import com.digitalhouse.rentcar.domain.entity.EnumRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSummaryResponse {

    private UUID id;
    private String name;

    private String email;


}
