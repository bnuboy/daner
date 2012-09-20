package com.bnuboy.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.example.daner.MyApp;
import com.example.daner.MyCookies;
import com.example.daner.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
	private TextView tv_username;
	private TextView tv_password;
	private Button   btn_login;
	String username;
	String password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		this.init();
	}
	public void init(){
		tv_username = (TextView)this.findViewById(R.id.username);
		tv_password = (TextView)this.findViewById(R.id.password);
		btn_login = (Button)this.findViewById(R.id.btn_login);
		btn_login.setOnClickListener(new LoginListenr());
		username = tv_username.getText().toString();
		password = tv_password.getText().toString();
		
	}
	class LoginListenr implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			String uriAPI = "http://www.oiegg.com/logging.php?action=login";
	        HttpPost httpRequest = new HttpPost(uriAPI); 
	        List <NameValuePair> params = new ArrayList <NameValuePair>(); 
	        params.add(new BasicNameValuePair("cookietime","259200"));
	        params.add(new BasicNameValuePair("referer","/"));
	        params.add(new BasicNameValuePair("username", username)); 
	        params.add(new BasicNameValuePair("password", password));
	        params.add(new BasicNameValuePair("loginsubmit","true"));
	        try 
	        { 
	          httpRequest.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
	          DefaultHttpClient hc = new DefaultHttpClient();
	          HttpResponse httpResponse = hc.execute(httpRequest);
	          List<Cookie> cookies = hc.getCookieStore().getCookies();
	          //MyApp myApp = ((MyApp)LoginActivity.this.getApplication());
	          //myApp.setCookie(hc.getCookieStore());
	          MyCookies.setCookie(hc.getCookieStore());
	          if(cookies.isEmpty()){
	        	  Log.v("cookie","cookies is none");
	          }else{
	        	  for(int i = 0;i < cookies.size();i++){
	        		  Log.v(cookies.get(i).getName(),cookies.get(i).getValue());
	        	  }
	          }
	          
	          if(httpResponse.getStatusLine().getStatusCode() == 200)  
	          { 
	            String strResult = EntityUtils.toString(httpResponse.getEntity()); 
	            Log.v("d",strResult); 
	            Log.v("sss",strResult);
	          } 
	          else 
	          { 
	        	  Log.v("d",httpResponse.getStatusLine().toString()); 
	          } 
	        }
	        catch (ClientProtocolException e) 
	        {  
	          Log.v("d",e.getMessage().toString()); 
	          e.printStackTrace(); 
	        } 
	        catch (IOException e) 
	        {  
	        	Log.v("d",e.getMessage().toString()); 
	        	e.printStackTrace(); 
	        } 
	        catch (Exception e) 
	        {  
	        	Log.v("d",e.getMessage().toString()); 
	          e.printStackTrace();  
	        }  
	         
		}
	
		
	}

}
