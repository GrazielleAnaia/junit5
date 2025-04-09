package com.grazielleanaia.junit5.api.request;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode

public class ResidenceRequestDTO {

    private Long id;

    private String street;

    private String complement;

    private String city;

    private String state;

    private Long zipcode;
}
