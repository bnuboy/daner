package com.bnuboy.web;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebContent {
	public static String getURLContent(String url, String encoding) {
		  StringBuffer content = new StringBuffer();
		  try {
		   // �½�URL����
		   URL u = new URL(url);
		   URLConnection ucon = u.openConnection();
		   ucon.setRequestProperty("cookie", "usewap=0");
		   
		   InputStream in = new BufferedInputStream(ucon.getInputStream());
		   InputStreamReader theHTML = new InputStreamReader(in, encoding);
		   int c;
		   while ((c = theHTML.read()) != -1) {
		    content.append((char) c);
		   }
		  }
		  // �����쳣
		  catch (MalformedURLException e) {
		   System.err.println(e);
		  } catch (IOException e) {
		   System.err.println(e);
		  }
		  return content.toString();
		 }
}