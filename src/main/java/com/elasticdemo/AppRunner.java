package com.elasticdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import com.elasticdemo.service.AWSElasticSearchService;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    AWSElasticSearchService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        service.createRecipeIndexRestClient();
      //  service.createOrdersIndex();
        
     //   service.createSubmissionIndex(100);
    }

}
