package com.elasticdemo.model.recipe;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "recipe")
public class Recipe {

    @Id
    int id;

    @Field(type = FieldType.Keyword)
    String title;

    @Field(type = FieldType.Auto)
    String description;

    @Field(type = FieldType.Integer)
    Integer preparation_time_minutes;

    @Field(type = FieldType.Nested, includeInParent = true)
    List<String> steps;

    @Field(type = FieldType.Nested, includeInParent = true)
    Serving servings;

    @JsonInclude
    @Field(type = FieldType.Nested, includeInParent = true)
    List<Ingredient> ingredients;

    @Field(type = FieldType.Date)
    Date created;

}
