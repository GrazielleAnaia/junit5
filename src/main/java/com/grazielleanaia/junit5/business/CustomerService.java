package com.grazielleanaia.junit5.business;

import com.grazielleanaia.junit5.api.converter.CustomerConverter;
import com.grazielleanaia.junit5.api.converter.CustomerMapper;
import com.grazielleanaia.junit5.api.converter.CustomerUpdateMapper;
import com.grazielleanaia.junit5.api.request.CustomerRequestDTO;
import com.grazielleanaia.junit5.api.response.CustomerResponseDTO;
import com.grazielleanaia.junit5.infrastructure.entity.CustomerEntity;
import com.grazielleanaia.junit5.infrastructure.exception.BusinessException;
import com.grazielleanaia.junit5.infrastructure.exception.ResourceNotFoundException;
import com.grazielleanaia.junit5.infrastructure.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor

public class CustomerService {

    private final CustomerConverter customerConverter;
    private final CustomerRepository customerRepository;
    private final CustomerUpdateMapper customerUpdateMapper;
    private final CustomerMapper customerMapper;

    public CustomerEntity saveCustomer(CustomerEntity entity) {
        return customerRepository.saveAndFlush(entity);
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        try {
            notNull(customerRequestDTO, "Customer data is mandatory");
            CustomerEntity entity = saveCustomer(customerConverter.convertToCustomerEntity(customerRequestDTO));
            return customerMapper.convertToCustomerResponseDTO(entity);
        } catch (Exception e) {
            throw new BusinessException("Error to save customer", e);
        }
    }

    public CustomerResponseDTO updateCustomer(CustomerRequestDTO customerRequestDTO) {
        try {
            notNull(customerRequestDTO, "Customer data is mandatory");
            CustomerEntity entity = customerRepository.findByEmail(customerRequestDTO.getEmail());
            CustomerEntity entity1 = customerUpdateMapper.updateCustomerEntity(customerRequestDTO, entity);
            return customerMapper.convertToCustomerResponseDTO(customerRepository.save(entity1));
        } catch (Exception e) {
            throw new BusinessException("Error to save customer", e);
        }
    }

    public CustomerResponseDTO searchCustomer(String email) {
        try {
            CustomerEntity entity = customerRepository.findByEmail(email);
            return customerMapper.convertToCustomerResponseDTO(entity);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Customer not found", e);
        }
    }

    public void deleteCustomerByEmail(String email) {
        try {
            CustomerEntity entity = customerRepository.findByEmail(email);
            customerRepository.delete(entity);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Customer not found", e);

        }

    }


}
