package com.grazielleanaia.junit5.api;


import com.grazielleanaia.junit5.api.request.CustomerRequestDTO;
import com.grazielleanaia.junit5.api.response.CustomerResponseDTO;
import com.grazielleanaia.junit5.business.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> saveCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDTO));
    }

    @GetMapping
    public ResponseEntity<CustomerResponseDTO> getCustomerByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(customerService.searchCustomer(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCustomerByEmail(@PathVariable String email){
        customerService.deleteCustomerByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO,
                                                              @RequestParam String email) {
        return ResponseEntity.ok(customerService.updateCustomer(customerRequestDTO));
    }
}
