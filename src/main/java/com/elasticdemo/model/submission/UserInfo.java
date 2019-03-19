package com.elasticdemo.model.submission;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserInfo {

    @Field(type = FieldType.Keyword)
    String userId;

    @Field(type = FieldType.Keyword)
    String firstName;

    @Field(type = FieldType.Keyword)
    String lastName;

    @Field(type = FieldType.Keyword)
    String employeeId;
}
