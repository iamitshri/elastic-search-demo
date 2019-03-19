package com.elasticdemo.model;

import java.util.Date;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/*
 * 
 * 
 * {"purchased_at":"2016-03-08T16:18:37Z","lines":[{"product_id":7,"amount":31.44,"quantity":2},{
 * "product_id":4,"amount":74.82,"quantity":2}],
 * "total_amount":106.26,"salesman":{"id":79,"name":"Ulberto Woodruff"},"sales_channel":"store",
 * "status":"completed"}
 * 
 * 
 */
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Order {

    Date purchased_at;
    ProductLine[] lines;
    Double total_amount;
    SalesPerson salesman;
    String sales_channel;
    String status;
}
