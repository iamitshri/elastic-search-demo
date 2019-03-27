package com.elasticdemo.model.order;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductLine {

    @Field(type = FieldType.Keyword)
    String product_id;

    @Field(type = FieldType.Double)
    Double amount;

    @Field(type = FieldType.Integer)
    int quantity;

}
