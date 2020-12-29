package com.ip.httprequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import  org.testng.annotations.Test;

import java.io.IOException;

public class Validation {
    @Test
    public  void validate() throws IOException {
        String URL = "https://reqres.in/api/users?page=2";

        HttpGet httpGet = new HttpGet(URL);  //passing d URL

        HttpClient httpClient = HttpClientBuilder.create().build();//creating httpclient instance

        HttpResponse httpResponse = httpClient.execute(httpGet);//hitting the URL

        String responsebody = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        //System.out.println(responsebody);

        ObjectMapper om = new ObjectMapper();  // from Jackson library
        JsonNode jsonNode= om.readTree(responsebody);
        JsonNode tot = jsonNode.get("total");
        System.out.println("the total is "+tot);


        String fname = jsonNode.get("data").get(5).get("first_name").asText();
        System.out.println(fname);
        Assert.assertEquals(fname,"Rachel");



    }
}
