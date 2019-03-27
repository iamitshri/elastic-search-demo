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
import com.elasticdemo.model.order.Orders;
import com.elasticdemo.model.recipe.Recipe;
import com.elasticdemo.model.recipe.RecipeElasticRepository;
import com.elasticdemo.model.recipe.Recipes;
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

    @Autowired
    RecipeElasticRepository recipeRepo;



    /**
     * Example of using RestHighlevel Client to create index using bulk upload api
     */
    public void createOrdersIndex() {
        BulkRequest bulkRequest = new BulkRequest();
        try {

            Orders orders = Util.getOrders();
            int cnt = 0;
            for (Order order : orders.getOrders()) {
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


    public void createRecipeIndexRestClient() {
        BulkRequest bulkRequest = new BulkRequest();
        try {

            Recipes recipes = Util.getRecipes();
            int cnt = 0;
            for (Recipe order : recipes.getRecipes()) {
                cnt++;
                IndexRequest request = new IndexRequest("recipelist", "recipelist", "" + cnt);
                request.source(mapper.convertValue(order, Map.class));
                bulkRequest.add(request);
            }
            BulkResponse result = restClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            log.debug(result.buildFailureMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createRecipeIndex() {
        try {
            Recipes orders = Util.getRecipes();
            recipeRepo.saveAll(orders.getRecipes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createSubmissionIndex(int numSubmissions) {
        if (numSubmissions <= 0)
            throw new IllegalArgumentException();
        List<Submission> subList = new ArrayList<>();
        for (int i = 0; i < numSubmissions; i++) {
            Submission submission = RandomPoJoGenerator.getObject(Submission.class);
            subList.add(submission);
        }
        buildIndexUsingBulkUpload(subList);
    }

    void buildIndexUsingBulkUpload(List<Submission> submissions) {

        log.info("Total # of submission objects: {}", submissions.size());
        try {
            submissionRepo.saveAll(submissions);
        } catch (ElasticsearchException e) {
            log.error("{}", e.getDetailedMessage());
        }
    }
}
