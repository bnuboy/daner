package com.bnuboy.web;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.http.cookie.Cookie;

import android.util.Log;

import com.example.daner.MyCookies;

public class WebContent {
	public static String getURLContent(String url, String encoding) {
		  

		  StringBuffer content = new StringBuffer();
		  try {
		   // 新建URL对象
		   URL u = new URL(url);
		   URLConnection ucon = u.openConnection();
		   ucon.setRequestProperty("cookie", "usewap=0");
		   List<Cookie> cookies = MyCookies.getCookie().getCookies();
		   String str_cookies = "usewap=0;";
           if(cookies.isEmpty()){
        	  Log.v("cookie","cookies is none");
           }else{
        	  Log.v("cookiestart","cookiestart");
        	  for(int i = 0;i < cookies.size();i++){
        		  Log.v(cookies.get(i).getName(),cookies.get(i).getValue());
        		  str_cookies += cookies.get(i).getName() + "=" + cookies.get(i).getValue() + ";";
        	  }
           }
           ucon.setRequestProperty("cookie", str_cookies);
		   InputStream in = new BufferedInputStream(ucon.getInputStream());
		   InputStreamReader theHTML = new InputStreamReader(in, encoding);
		   int c;
		   while ((c = theHTML.read()) != -1) {
		    content.append((char) c);
		   }
		  }
		  // 处理异常
		  catch (MalformedURLException e) {
		   System.err.println(e);
		  } catch (IOException e) {
		   System.err.println(e);
		  }
		  return content.toString();
		 }
	public static String getWapURLContent(String url, String encoding) {
		  StringBuffer content = new StringBuffer();
		  try {
		   // 新建URL对象
		   URL u = new URL(url);
		   URLConnection ucon = u.openConnection();
		   ucon.setRequestProperty("cookie", "usewap=1");
		   
		   InputStream in = new BufferedInputStream(ucon.getInputStream());
		   InputStreamReader theHTML = new InputStreamReader(in, encoding);
		   int c;
		   while ((c = theHTML.read()) != -1) {
		    content.append((char) c);
		   }
		  }
		  // 处理异常
		  catch (MalformedURLException e) {
		   System.err.println(e);
		  } catch (IOException e) {
		   System.err.println(e);
		  }
		  return content.toString();
		 }
}
