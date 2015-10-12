/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nibss.util;

import java.io.PrintStream;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author famodungbolaga
 */
public class Request {
    public void get(String url)
    throws Exception
  {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try
    {
      HttpGet httpGet = new HttpGet(url);
      CloseableHttpResponse response1 = httpclient.execute(httpGet);
      try
      {
        HttpEntity entity1 = response1.getEntity();
        
        EntityUtils.consume(entity1);
      }
      finally
      {
        response1.close();
      }
    }
    finally
    {
      httpclient.close();
    }
  }
  
  public void post(String url, List<NameValuePair> list)
    throws Exception
  {
    CloseableHttpClient httpclient = HttpClients.createDefault();
    try
    {
      HttpPost httpPost = new HttpPost(url);
      
      httpPost.setEntity(new UrlEncodedFormEntity(list));
      CloseableHttpResponse response2 = httpclient.execute(httpPost);
      try
      {
        System.out.println(response2.getStatusLine().getStatusCode());
        HttpEntity entity2 = response2.getEntity();
        
        EntityUtils.consume(entity2);
      }
      finally
      {
        response2.close();
      }
    }
    finally
    {
      httpclient.close();
    }
  }
}
