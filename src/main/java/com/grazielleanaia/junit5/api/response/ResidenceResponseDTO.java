package com.grazielleanaia.junit5.api.response;

public record ResidenceResponseDTO(Long id,
                                   String street,
                                   String complement,
                                   String city,
                                   String state,
                                   Long zipcode) {
}
