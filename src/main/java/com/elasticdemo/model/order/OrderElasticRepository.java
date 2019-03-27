package com.elasticdemo.model.order;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OrderElasticRepository extends ElasticsearchRepository<Order, Long> {

}
