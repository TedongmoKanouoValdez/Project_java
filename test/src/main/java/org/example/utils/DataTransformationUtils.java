package org.example.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataTransformationUtils {
    public static String toJson(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try{
            json = mapper.writerWithDefaultPrettyPrinter()
                         .writeValueAsString(obj);
            return json;
        }catch(JsonProcessingException e){
            System.err.println("Erreur lors de la conversion en JSON : " + e.getMessage());
            return "{}";
        }
    }
}

