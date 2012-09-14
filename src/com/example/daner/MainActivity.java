package com.example.daner;




import com.bnuboy.index.IndexList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	private IndexList iList;
	private Context ctx = this;
	MyHandler mh;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mh = new MyHandler();
		MyThread mt = new MyThread();
		new Thread(mt).run();
		
		MyThread1 mt1 = new MyThread1();
		new Thread(mt1).run();
        
    }

    @Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//setContentView(R.layout.welcom);
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	class MyHandler extends Handler{

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			Bundle msgData = msg.getData();
			String msgStr = (String)msgData.get("msg");
			Log.v("ddddd", msgStr);
			if(msgStr == "welcom"){

				MainActivity.this.setContentView(R.layout.welcom);
			}else{
				Log.v("ddddd",msgStr);
				iList = new IndexList(ctx);
				iList.list();
				Log.v("if","first");
				MainActivity.this.setContentView(iList);
			}
			
		}
		
	}
    class MyThread implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			
			
			Message msg = new Message();
			Bundle msgBundle = new Bundle();
			msgBundle.putString("msg", "welcom");
			msg.setData(msgBundle);
			mh.sendMessage(msg);
			
		}
    	
    }
    
    class MyThread1 implements Runnable{

		public void run() {
			// TODO Auto-generated method stub
			
			
			Message msg1 = new Message();
			Bundle msgBundle1 = new Bundle();
			msgBundle1.putString("msg", "update");
			msg1.setData(msgBundle1);
			mh.sendMessage(msg1);
			
		}
    	
    }
    
}
