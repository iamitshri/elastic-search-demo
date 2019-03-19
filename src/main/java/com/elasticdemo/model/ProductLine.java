package com.elasticdemo.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/*
 * 
 * {"product_id":7,"amount":31.44,"quantity":2}
 */
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class ProductLine {
    
    String product_id;
    Double amount;
    int quantity;

}
