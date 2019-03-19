package com.elasticdemo.model.submission;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SubmissionElasticRepository extends ElasticsearchRepository<Submission, Long> {

}
