package org.example.UtilityClasses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.Model.Student;
import org.example.Model.University;

import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }
   public static String writeListToJson(List<?> list){
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
   }

}
