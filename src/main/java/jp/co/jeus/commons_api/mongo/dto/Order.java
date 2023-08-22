package jp.co.jeus.commons_api.mongo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Order {
    private String orderId;
    private int price;
}
