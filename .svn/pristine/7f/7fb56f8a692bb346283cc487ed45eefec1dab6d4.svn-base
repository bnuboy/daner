package com.bnuboy.third;

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

import com.bnuboy.content.ContentActivity;
import com.bnuboy.web.WebContent;
import com.example.daner.R;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ThirdList extends ListView{
	
	private ListView listView;
	List<Map<String, String>> data;
	private String url;
	private String encode;
	private String regex;
	private String strStart;
	private String strEnd;
	private Context context;
	private boolean usewap;
	private int filter;
	public ThirdList(Context context) {
		super(context);
		this.context = context;
		this.strStart = "";
		this.strEnd   = "";
		this.encode   = "UTF-8";
		this.usewap   = false;
		this.filter   = 2;
	}
	public void setUsewap(boolean usewap){
		this.usewap = usewap;
	}
	public void setStrStart(String strStart){
		this.strStart = strStart;
	}
	public void setStrEnd(String strEnd){
		this.strEnd   = strEnd;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public void setEncode(String encode){
		this.encode = encode;
	}
	public void setRegex(String regex){
		this.regex = regex;
	}
	public boolean list(){
		//listView = (ListView)this.findViewById(R.id.titleList);
		data = getData();
	    SimpleAdapter sa = new SimpleAdapter(this.getContext(), data, R.layout.liststyle, new String []{"title" , "img"}, new int []{ R.id.leftText,R.id.rightText});
	    this.setAdapter(sa);
	    setOnItemClickListener(new IndexListListener());
	    return true;
	}
	
	private List<Map<String, String>> getData() {

    	DefaultHttpClient hc = new DefaultHttpClient();
    	List<Cookie> cookies = hc.getCookieStore().getCookies();
    	HttpGet hg = new HttpGet("http://www.oiegg.com/?wap=0");
    	try {
			HttpResponse hr = hc.execute(hg);
			String str = hr.toString();
			Log.v("response",str);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			Log.v("httpget","httpget异常");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.v("httpget","httpget异常");
			e.printStackTrace();
		}
    	if(cookies.isEmpty()){
    		Log.v("cookies", "none");
    	}else{
    		Log.v("cookies","not none");
    	}
    	//map.put(参数名字,参数值)         
    	List<Map<String, String>> list = new ArrayList<Map<String, String>>();         
    	String content; 
    	if(this.usewap){
    		content = WebContent.getWapURLContent(this.url, this.encode);
    	}else{
    		content = WebContent.getURLContent(this.url, this.encode);
    	}
    	String regex1 = this.strStart + "(.*)" + this.strEnd;
    	Pattern p1 = Pattern.compile(regex1,Pattern.DOTALL);
    	Matcher m1 = p1.matcher(content);
    	if(m1.find()){
    		content = m1.group(1);
    	}
    	Log.v("ccccc",content);
        String regex = "(<li><a href=\")(.*)(\">)(.*)(</a></li>)";
        Pattern p = Pattern.compile(this.regex);
        Matcher m = p.matcher(content);
        int i = 0;
        while(m.find()){
        	//String str1 = m.group(2) + "         " + m.group(4);
        	if(i < this.filter){
        		i++;
        	}else{
	        	Map<String, String> map = new HashMap<String, String>();   
	        	map.put("title", m.group(1));
	        	map.put("img", m.group(2));
	        	list.add(map);
        	}
        }       
    	return list;         
    }
	class IndexListListener implements OnItemClickListener{

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			Log.v("item", data.get(arg2).get("title"));
			Bundle bundle = new Bundle();
			bundle.putString("tid", data.get(arg2).get("title"));
			Intent intent = new Intent(ThirdList.this.context,ContentActivity.class);
			intent.putExtras(bundle);
			ThirdList.this.context.startActivity(intent);
		}	
	}

	
}
