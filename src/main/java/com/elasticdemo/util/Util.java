package com.elasticdemo.util;

import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import com.elasticdemo.model.order.Orders;
import com.elasticdemo.model.recipe.Recipes;
import com.google.gson.Gson;



public class Util {

    public static Orders getOrders() {
        Gson gson = new Gson();
        return gson.fromJson(getInputStreamReader("/data/orders.json"), Orders.class);
    }

    public static Recipes getRecipes() {
        Gson gson = new Gson();
        return gson.fromJson(getInputStreamReader("/data/recipes.json"), Recipes.class);
    }

    static InputStreamReader getInputStreamReader(String filePath) {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource jsonFile = resolver.getResource(filePath);
        try {
            return new InputStreamReader(jsonFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
