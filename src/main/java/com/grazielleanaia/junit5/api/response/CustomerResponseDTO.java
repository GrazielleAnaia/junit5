package com.grazielleanaia.junit5.api.response;

import java.time.LocalDateTime;

public record CustomerResponseDTO(Long id,
                                  String name,
                                  String email,
                                  String document,
                                  LocalDateTime registrationDate,
                                  ResidenceResponseDTO residence) {
}
