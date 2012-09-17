package com.bnuboy.index;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

import com.bnuboy.web.WebContent;

public class IndexContent {

	public static List<Map<String, String>> getData() {

    	List<Map<String, String>> list = new ArrayList<Map<String, String>>();         
    	  
    	
    	String content = WebContent.getURLContent("http://www.oiegg.com/index.php", "UTF-8");
        String regex = "(<li><a href=\")(.*)(\">)(.*)(</a></li>)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        while(m.find()){
        	//String str1 = m.group(2) + "         " + m.group(4);
        	Map<String, String> map = new HashMap<String, String>();   
        	map.put("title", m.group(2));
        	map.put("img", m.group(4));
        	Log.v("111111", m.group(4));
        	list.add(map);
        }       
    	return list;         
    }
}
