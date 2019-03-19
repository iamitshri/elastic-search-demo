package com.elasticdemo.service;

import java.util.List;
import java.util.Map;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elasticdemo.model.Order;
import com.elasticdemo.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AWSElasticSearchService {


    @Autowired
    RestHighLevelClient restClient;

    ObjectMapper mapper = new ObjectMapper();


    public void bulkUpload() {
        BulkRequest bulkRequest = new BulkRequest();
        try {
            List<Order> orders = Util.getOrdersFromJsonFile();
            int cnt = 0;
            for (Order order : orders) {
                cnt++;
                IndexRequest request = new IndexRequest("orders", "orders",""+cnt);
                request.source(mapper.convertValue(order, Map.class));
                bulkRequest.add(request);
            }
            BulkResponse result = restClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            log.debug(result.buildFailureMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
