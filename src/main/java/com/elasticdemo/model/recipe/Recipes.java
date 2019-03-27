package com.elasticdemo.model.recipe;

import java.util.List;
import lombok.Data;

@Data
public class Recipes {

    List<Recipe> recipes;

    public List<Recipe> getRecipes() {
        // TODO Auto-generated method stub
        return recipes;
    }

    

}
