package com.elasticdemo.model.submission;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Show evaluation info for all prior submissions along with their result and evaluator ID
 * 
 * @author amit.shrigondekar
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrevSubmissions {

    Long submissionId;
    
    int attempt;

    String submissionStatus;

    String evaluatorId;

    Long evaluationId;
}
