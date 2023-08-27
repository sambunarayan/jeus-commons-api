package jp.co.jeus.commons_api.commons.repository.mongo;

import jp.co.jeus.commons_api.mongo.dto.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer deleteByCustomerId(String customerId);
}
