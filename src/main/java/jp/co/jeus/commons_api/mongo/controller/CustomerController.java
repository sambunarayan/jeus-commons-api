package jp.co.jeus.commons_api.mongo.controller;

import jp.co.jeus.commons_api.mongo.dto.Customer;
import jp.co.jeus.commons_api.mongo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("findAll")
    public List<Customer> findAll() {
        return customerService.find();
    }

    @PostMapping("save")
    public void save(@RequestBody Customer customer) {
        customerService.insert(customer);
    }

    @DeleteMapping("del")
    public void delete(@RequestBody Customer customer) {
        customerService.delete(customer.getCustomerId());
    }
}
