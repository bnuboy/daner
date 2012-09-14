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

import com.bnuboy.web.WebContent;
import com.example.daner.R;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class IndexList extends ListView{
	
	private ListView listView;
	private Context ctx;
	List<Map<String, String>> data;
	public IndexList(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.ctx = context;
		
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
	class IndexListListener implements OnItemClickListener{

		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			Log.v("item", data.get(arg2).get("title"));
		}
		
	}

	
}
