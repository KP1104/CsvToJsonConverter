package com.CsvToJson.csvToJson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvToJsonConverter {
    public static JSONArray csvToJsonConverter(String filePath) {
        JSONArray jsonArray = new JSONArray();
        try {


            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String headerLine = br.readLine();
            if (headerLine == null) {
                throw new IOException("Empty CSV File");
            }
            String[] headers = headerLine.split(",");

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                JSONObject jsonObject = new JSONObject();

                for (int i = 0; i < headers.length; i++) {
                    System.out.println(headers[i] + values[i]);
                    jsonObject.put(headers[i], values[i]);
                }

                jsonArray.put(jsonObject);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public static void main(String[] args) {
        JSONArray result = csvToJsonConverter("/Users/kp/Downloads/football_mini.csv");
        System.out.println(result);
    }
}
