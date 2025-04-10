package com.grazielleanaia.junit5.api;


import com.grazielleanaia.junit5.api.request.CustomerRequestDTO;
import com.grazielleanaia.junit5.api.response.CustomerResponseDTO;
import com.grazielleanaia.junit5.business.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDTO));
    }
}
