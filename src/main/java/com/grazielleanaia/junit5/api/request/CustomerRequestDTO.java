package com.grazielleanaia.junit5.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode

public class CustomerRequestDTO {
    private Long id;

    private String name;

    @JsonProperty(required = true)
    private String email;

    private String document;

    private ResidenceRequestDTO residence;
}
