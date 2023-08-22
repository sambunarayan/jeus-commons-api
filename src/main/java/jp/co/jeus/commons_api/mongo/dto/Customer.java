package jp.co.jeus.commons_api.mongo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Setter
@Getter
public class Customer {

    @Id
    private String id;
    private String customerId;
    private String customerName;
    private int age;
    private List<Order> orders;
}
