package com.elasticdemo.model.recipe;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Serving {

    @Field(type = FieldType.Integer)
    Integer min;

    @Field(type = FieldType.Integer)
    Integer max;

}
