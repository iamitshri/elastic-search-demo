package com.elasticdemo.model.order;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "orders")
public class Order {

    @Id
    Long id;
    
    @Field(type = FieldType.Date)
    Date purchased_at;
    
    @Field(type = FieldType.Nested,includeInParent=true)
    ProductLine[] lines;
    
    @Field(type = FieldType.Double)
    Double total_amount;
    
    @Field(type = FieldType.Auto)
    SalesPerson salesman;
    
    @Field(type = FieldType.Auto)
    String sales_channel;
    
    @Field(type = FieldType.Keyword)
    String status;
}
