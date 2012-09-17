/**
 * 呈现首页欢迎界面，一秒之后转到首页导航IndexNav
 */
package com.example.daner;

import com.bnuboy.index.IndexNav;

import android.os.Bundle;
import android.os.Handler;
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
        }, 3000);

    }

}
