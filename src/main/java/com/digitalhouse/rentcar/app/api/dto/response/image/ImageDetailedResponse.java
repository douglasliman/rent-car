package com.digitalhouse.rentcar.app.api.dto.response.image;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ImageDetailedResponse {
    private UUID id;

    private String title;

    private String url;
}
