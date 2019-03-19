package com.elasticdemo.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/*
 * "salesman":{"id":79,"name":"Ulberto Woodruff"}
 */
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
public class SalesPerson {

    Long id;
    String name;
}
