package com.grazielleanaia.junit5.api.converter;


import com.grazielleanaia.junit5.api.request.CustomerRequestDTO;
import com.grazielleanaia.junit5.infrastructure.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface CustomerUpdateMapper {
    public CustomerEntity updateCustomerEntity(CustomerRequestDTO customerRequestDTO, @MappingTarget CustomerEntity customerEntity);
}
