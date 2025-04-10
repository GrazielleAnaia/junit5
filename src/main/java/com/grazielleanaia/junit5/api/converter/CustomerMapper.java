package com.grazielleanaia.junit5.api.converter;


import com.grazielleanaia.junit5.api.request.CustomerRequestDTO;
import com.grazielleanaia.junit5.api.response.CustomerResponseDTO;
import com.grazielleanaia.junit5.infrastructure.entity.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    public CustomerEntity convertToCustomerEntity(CustomerRequestDTO customerRequestDTO);

    public CustomerResponseDTO convertToCustomerResponseDTO(CustomerEntity customerEntity);


}
