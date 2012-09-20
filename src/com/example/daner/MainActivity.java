/**
 * 呈现首页欢迎界面，一秒之后转到首页导航IndexNav
 */
package com.example.daner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.bnuboy.index.IndexNav;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.app.Activity;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcom);
       
        new Handler().postDelayed(new Runnable(){
        	public void run() {
        		new IndexNav(MainActivity.this);
        	}
        }, 1000);
        
        
    } 
    

}
