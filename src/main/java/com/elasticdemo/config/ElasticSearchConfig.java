package com.elasticdemo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@Configuration
public class ElasticSearchConfig {


    @Value("${com.elasticdemo.aws.url}")
    private String elasticsearchHost;

    @Value("${com.elasticdemo.local.url}")
    private String localElasticHost;

    @Bean(destroyMethod = "close")
    @ConditionalOnProperty(name = "com.elasticdemo.aws.url")
    public RestHighLevelClient client() {

        RestHighLevelClient client = null;
        client = new RestHighLevelClient(RestClient.builder(HttpHost.create(elasticsearchHost)));
        return client;
    }

    @Bean(destroyMethod = "close")
    @ConditionalOnProperty(name = "com.elasticdemo.local.url")
    public RestHighLevelClient clientLocal() {

        RestHighLevelClient client = null;
        client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "Http"), new HttpHost("localhost", 9201, "http")));

        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        if (!"false".equalsIgnoreCase(elasticsearchHost)) {
            return new ElasticsearchRestTemplate(client());
        } else {
            return new ElasticsearchRestTemplate(clientLocal());
        }
    }

}


