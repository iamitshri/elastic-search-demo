package com.elasticdemo.model.submission;

import java.util.Date;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Evaluation {

    @Field(type=FieldType.Long)
    Long evaluationId;
    
    @Field(type=FieldType.Nested,includeInParent=true)
    UserInfo evaluator;
    
    @Field(type=FieldType.Keyword)
    String evaluatorId;
    
    @Field(type=FieldType.Long)
    Long submissionId;
    
    @Field(type=FieldType.Keyword)
    String status;
    
    @Field(type=FieldType.Integer)
    int minutesSpent;
    
    @Field(type = FieldType.Date)
    Date evaluationDateStarted;
    
    @Field(type = FieldType.Date)
    Date evaluationDateCompleted;
    
    @Field(type = FieldType.Date)
    Date evaluationDateUpdated;
}
