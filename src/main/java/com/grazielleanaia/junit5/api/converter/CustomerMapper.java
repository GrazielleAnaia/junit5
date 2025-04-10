package com.grazielleanaia.junit5.api.converter;


import com.grazielleanaia.junit5.api.request.CustomerRequestDTO;
import com.grazielleanaia.junit5.api.response.CustomerResponseDTO;
import com.grazielleanaia.junit5.infrastructure.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "id", target = "id")


    public CustomerEntity convertToCustomerEntity(CustomerRequestDTO customerRequestDTO);

    public CustomerResponseDTO convertToCustomerResponseDTO(CustomerEntity customerEntity);


}
