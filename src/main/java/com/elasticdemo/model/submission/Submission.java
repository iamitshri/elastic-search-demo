package com.elasticdemo.model.submission;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.Data;

@Data
@Document(indexName = "submission")
public class Submission {

    @Id
    Long submissionId;

    @Field(type = FieldType.Keyword)
    String studentId;

    @Field(type = FieldType.Keyword)
    String status;

    @Field(type = FieldType.Integer)
    int attempt;

    @Field(type = FieldType.Long)
    Long pidm;

    @Field(type = FieldType.Nested, includeInParent = true)
    List<Evaluation> evaluations;
    
    @Field(type=FieldType.Long)
    Long taskId;

    @Field(type = FieldType.Date)
    Date dateCreated;

    @Field(type = FieldType.Date)
    Date dateSubmitted;

    @Field(type = FieldType.Date)
    Date dateUpdated;

    @Field(type = FieldType.Date)
    Date dateEstimated;

    @Field(type = FieldType.Date)
    Date evaluationDateStarted;

    @Field(type = FieldType.Date)
    Date evaluationDateCompleted;
    
    @Field(type=FieldType.Nested,includeInParent=true)
    List<PrevSubmissions> previousSubmissions;
}
