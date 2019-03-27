package com.elasticdemo.model.order;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalesPerson {

    @Field(type = FieldType.Long)
    Long id;

    @Field(type = FieldType.Keyword)
    String name;
}
