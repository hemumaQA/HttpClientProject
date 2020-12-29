package com.ip.httprequest;


import org.apache.http.Header;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import  org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

//GET REQUEST
public class GETrequest {
    @Test
    public  void getrequest() throws IOException {

        String URL = "https://reqres.in/api/users?page=2";

        HttpGet httpGet = new HttpGet(URL);  //passing d URL

        HttpClient httpClient = HttpClientBuilder.create().build();

        HttpResponse httpResponse = httpClient.execute(httpGet);//hitting the URL
       //-----------------------------------------------------------------
        int statuscode  = httpResponse.getStatusLine().getStatusCode(); //getting status code

        System.out.println("the statuscode is "+statuscode);

        Assert.assertEquals(statuscode,200);   //success code-200

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
