package com.elasticdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elasticdemo.model.order.Order;
import com.elasticdemo.model.submission.Submission;
import com.elasticdemo.model.submission.SubmissionElasticRepository;
import com.elasticdemo.util.RandomPoJoGenerator;
import com.elasticdemo.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AWSElasticSearchService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AWSElasticSearchService.class);


    @Autowired
    RestHighLevelClient restClient;


    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    SubmissionElasticRepository submissionRepo;


    public void bulkUpload() {
        BulkRequest bulkRequest = new BulkRequest();
        try {
            List<Order> orders = Util.getOrdersFromJsonFile();
            int cnt = 0;
            for (Order order : orders) {
                cnt++;
                IndexRequest request = new IndexRequest("orders", "orders", "" + cnt);
                request.source(mapper.convertValue(order, Map.class));
                bulkRequest.add(request);
            }
            BulkResponse result = restClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            log.debug(result.buildFailureMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSubmissionIndex() {
        List<Submission> subList = new ArrayList<Submission>();
        Submission submission = RandomPoJoGenerator.getEntity(Submission.class);
        subList.add(submission);
        buildIndexUsingBulkUpload(subList);
    }

    public void buildIndexUsingBulkUpload(List<Submission> submissions) {

        log.info("Total # of submission objects: {}", submissions.size());
        try {
            submissionRepo.saveAll(submissions);
        } catch (ElasticsearchException e) {
            log.error("{}", e.getDetailedMessage());
        }
    }
}
