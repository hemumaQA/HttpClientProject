package com.ip.httprequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import  org.testng.annotations.Test;

import java.io.IOException;

public class DELETErequest {
    @Test
    public  void deleterequest() throws IOException {
        String URL ="https://reqres.in/api/users/2";
        HttpDelete httpDelete = new HttpDelete(URL);
        HttpClient httpClient= HttpClientBuilder.create().build();

        HttpResponse httpResponse = httpClient.execute(httpDelete);
        int statuscode  = httpResponse.getStatusLine().getStatusCode(); //getting status code

        System.out.println("the statuscode is "+statuscode);

        Assert.assertEquals(statuscode,204);//no- content code-204 ok

    }
}
