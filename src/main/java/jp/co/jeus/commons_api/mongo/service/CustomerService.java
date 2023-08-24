package jp.co.jeus.commons_api.mongo.service;

import jp.co.jeus.commons_api.commons.repository.mongo.CustomerRepository;
import jp.co.jeus.commons_api.mongo.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> find() {
        return customerRepository.findAll();
    }

    public void insert(Customer customer) {
        customerRepository.save(customer);
    }
}
