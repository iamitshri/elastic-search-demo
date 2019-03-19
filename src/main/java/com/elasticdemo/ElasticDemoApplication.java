package com.elasticdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = ElasticsearchDataAutoConfiguration.class)
public class ElasticDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticDemoApplication.class, args)
                         .close();
    }

}
