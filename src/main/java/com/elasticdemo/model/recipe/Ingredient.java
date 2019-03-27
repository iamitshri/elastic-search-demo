package com.elasticdemo.model.recipe;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/*
 * {
        "name": "Dry pasta",
        "quantity": "450g"
    }
 */
@Data
@FieldDefaults(level=AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Ingredient {
    
    @Field(type = FieldType.Auto)
    String name;
    
    @Field(type = FieldType.Auto)
    String quantity;

}
