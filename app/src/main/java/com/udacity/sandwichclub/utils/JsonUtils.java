package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
       try {


        JSONObject FastFood = new JSONObject(json);

        JSONObject name=FastFood.getJSONObject("name");
        String mainName =name.getString("mainName");
        JSONArray alsoKnownAs=name.getJSONArray("alsoKnownAs");
        ArrayList<String> alsoKnownAsList =new ArrayList<>();
        for (int x=0; x<alsoKnownAs.length();x++){
            alsoKnownAsList.add(alsoKnownAs.getString(x));
        }
       String placeOfOrigin =FastFood.getString("placeOfOrigin");
           String description=FastFood.getString("description");
           String image=FastFood.getString("image");
           JSONArray ingredients =FastFood.getJSONArray("ingredients");
           ArrayList<String>ingredientsList =new ArrayList<>();
           for (int x=0;x<ingredients.length();x++){
               ingredientsList.add(ingredients.getString(x));
           }
return new Sandwich(mainName,alsoKnownAsList,placeOfOrigin,description,image,ingredientsList);

    }catch (JSONException e){
           e.printStackTrace();
       }
       return null;
    }
}
