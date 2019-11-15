package com.spring.study_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/customer")
public class MainController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path="/viewAll")
    public @ResponseBody Iterable<Customer> getAllCustomer () {
        return customerRepository.findAll();
    }

    @GetMapping(path="/viewName/{name}")
    public @ResponseBody List<Customer> getOneCustomer(@PathVariable String name) {
        return customerRepository.findByLastName(name);
    }

    @PostMapping(path="/add")
    public @ResponseBody  String addCustomer (@RequestBody Customer A) {
        customerRepository.save(A);
        return "SUCCESS";
    }
}
