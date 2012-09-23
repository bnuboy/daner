package com.bnuboy.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.util.Log;

import com.example.daner.MyCookies;

public class MyHttpPost {
	List <NameValuePair> params = new ArrayList <NameValuePair>();
	String url;
	HttpPost httpRequest; 
	public MyHttpPost(){
	}
	public MyHttpPost(String url){
		this.url = url;
		httpRequest = new HttpPost(this.url);
	}
	public void setUrl(String url){
		this.url = url;
		httpRequest = new HttpPost(this.url);
	}
	public void setParams(List<NameValuePair> params){
		this.params = params;
	}
	public List<NameValuePair> getParams(){
		return this.params;
	}
	public void addParam(String name,String value){
		this.params.add(new BasicNameValuePair(name,value));
	}
    
    public void post(){
    	try {
			httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			//httpRequest.setHeader("Content-Type", "multipart/form-data;");
			DefaultHttpClient hc = new DefaultHttpClient();
			hc.setCookieStore(MyCookies.getCookie());
	        HttpResponse httpResponse = hc.execute(httpRequest);
	        if(httpResponse.getStatusLine().getStatusCode() == 200){
			    String strResult = EntityUtils.toString(httpResponse.getEntity());
			    int n = strResult.indexOf("id=\"nav\"");
			    strResult = strResult.substring(n);
			    Log.v("content", "" + strResult);
	        }else{ 
	    	    Log.v("d",httpResponse.getStatusLine().toString()); 
	        }
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
