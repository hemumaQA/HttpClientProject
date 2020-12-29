package com.ip.httprequest;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import  org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class PUTrequest {
    @Test
    public  void putrequest() throws IOException {
         String URL ="https://reqres.in/api/users/2";
        HttpPut httpPut = new HttpPut(URL);
        HttpClient httpClient= HttpClientBuilder.create().build();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Preethi");
        jsonObject.put("id","125");
        jsonObject.put("job","Software Designer");
        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        httpPut.setEntity(stringEntity);

        HttpResponse httpResponse = httpClient.execute(httpPut);
        //----------------------------------------------------------
        int statuscode  = httpResponse.getStatusLine().getStatusCode(); //getting status code

        System.out.println("the statuscode is "+statuscode);

        Assert.assertEquals(statuscode,200);//success code-200 ok
        //getting the response body
        String responsebody = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        System.out.println(responsebody);

        HashMap<String,String> hp = new HashMap<String,String>();
        hp.put("Content-type","application/json");

              }

    }





