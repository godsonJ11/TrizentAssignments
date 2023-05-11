package com.jsonreader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;


public class Jsonreader{
    public static void main(String[] args) throws IOException {
         //          Java to json
        ObjectMapper objectMapper = new ObjectMapper();
        StudentsDetails studentsDetails= new StudentsDetails(1,"sarah",23);
        String jsonData=objectMapper.writeValueAsString(studentsDetails);
//       jsonData=objectMapper.writeValueAsString(studentsDetails2);
        objectMapper.writeValue(new File("C:\\Users\\clint\\OneDrive\\Desktop\\Students_jsData\\data.json"),jsonData);
        //           json to java
        ObjectMapper objectMapper1= new ObjectMapper();
        File file= new File("C:\\Users\\clint\\OneDrive\\Desktop\\Students_jsData\\data.json");
        JsonNode jsonNode= objectMapper.readTree(file);
        String jsonValue=jsonNode.toString();
//        System.out.println(jsonValue);
        jsonValue =  jsonValue.replaceAll("\\{", "").replaceAll("}", "");
//        System.out.println(jsonValue);

        String[] splitValues = jsonValue.split(",");
//      System.out.println(splitValues[2]);
        for (String pair : splitValues ) {
            String[] parts = pair.split(":");


            String key = parts[0].trim().replaceAll("\"", "");
            String value = parts[1].trim().replaceAll("\"", "");
            key = key.replaceAll("\\\\", "");
            value = value.replaceAll("\\\\", "");
            System.out.println(key + "=" + value);
        }

    }
}
