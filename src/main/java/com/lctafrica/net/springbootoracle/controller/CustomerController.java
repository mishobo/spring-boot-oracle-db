package com.lctafrica.net.springbootoracle.controller;

import com.lctafrica.net.springbootoracle.model.Customer;
import com.lctafrica.net.springbootoracle.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api/")
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping(value = "/customers", produces = "Application/json")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        try{
            List<Customer> customers = new ArrayList<>();
            customerRepository.findAll().forEach(customers::add);

            if (customers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/customer/{id}", produces = "Application/json")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id){
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
