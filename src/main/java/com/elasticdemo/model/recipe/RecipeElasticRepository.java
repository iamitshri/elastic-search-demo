package com.elasticdemo.model.recipe;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RecipeElasticRepository extends ElasticsearchRepository<Recipe, Long> {

}
