package com.grazielleanaia.junit5.api.converter;

import com.grazielleanaia.junit5.api.request.CustomerRequestDTO;
import com.grazielleanaia.junit5.api.request.ResidenceRequestDTO;
import com.grazielleanaia.junit5.infrastructure.entity.CustomerEntity;
import com.grazielleanaia.junit5.infrastructure.entity.ResidenceEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerConverter {

    public CustomerEntity convertToCustomerEntity(CustomerRequestDTO customerRequestDTO) {
        return CustomerEntity.builder()
                .name(customerRequestDTO.getName())
                .email(customerRequestDTO.getEmail())
                .document(customerRequestDTO.getDocument())
                .registrationDate(LocalDateTime.now())
                .residence(convertToResidenceEntity(customerRequestDTO.getResidence()))
                .build();
    }

    public ResidenceEntity convertToResidenceEntity(ResidenceRequestDTO residenceRequestDTO) {
        return ResidenceEntity.builder()
                .street(residenceRequestDTO.getStreet())
                .complement(residenceRequestDTO.getComplement())
                .city(residenceRequestDTO.getCity())
                .state(residenceRequestDTO.getState())
                .zipcode(residenceRequestDTO.getZipcode())
                .build();
    }

    public CustomerRequestDTO convertToCustomerRequestDTO(CustomerEntity customerEntity) {
        return CustomerRequestDTO.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .email(customerEntity.getEmail())
                .document(customerEntity.getDocument())
                .residence(convertToResidenceRequestDTO(customerEntity.getResidence()))
                .build();
    }

    public ResidenceRequestDTO convertToResidenceRequestDTO(ResidenceEntity residenceEntity) {
        return ResidenceRequestDTO.builder()
                .id(residenceEntity.getId())
                .street(residenceEntity.getStreet())
                .complement(residenceEntity.getComplement())
                .city(residenceEntity.getCity())
                .state(residenceEntity.getState())
                .zipcode(residenceEntity.getZipcode())
                .build();
    }
}
