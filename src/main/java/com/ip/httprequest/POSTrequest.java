package com.ip.httprequest;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import  org.testng.annotations.Test;

import java.io.IOException;

import java.util.HashMap;

public class POSTrequest {

    @Test
    public void getrequest() throws IOException {
        String URL = "https://reqres.in/api/users";
        HttpPost httpPost = new HttpPost(URL);
        HttpClient httpClient = HttpClientBuilder.create().build();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","Uma");
        jsonObject.put("id","555");
        jsonObject.put("job","QA engineer");
        StringEntity stringEntity = new StringEntity(jsonObject.toString());
        httpPost.setEntity(stringEntity );
        HttpResponse httpResponse = httpClient.execute(httpPost);

             //-------------------------------------
        int statuscode  = httpResponse.getStatusLine().getStatusCode(); //getting status code

        System.out.println("the statuscode is "+statuscode);

        Assert.assertEquals(statuscode,201);//created code-201
        //getting the response body
        String responsebody = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
        System.out.println(responsebody);
        //getting the Header info
        Header[] allHeaders = httpResponse.getAllHeaders();
        HashMap<String,String> hp = new HashMap<String, String>();
        for(Header h:allHeaders){
            hp.put(h.getName(),h.getValue());
            System.out.println(hp);
        }

    }


    }

