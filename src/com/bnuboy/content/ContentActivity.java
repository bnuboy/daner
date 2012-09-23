package com.bnuboy.content;

import com.bnuboy.index.IndexList;
import com.bnuboy.reply.ReplyActivity;
import com.bnuboy.web.WebContent;
import com.example.daner.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ContentActivity extends Activity {
	private ContentListView cListView;
	private TextView        newthread;
	private TextView        reply;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		Intent intent = this.getIntent();
		Bundle bundle = intent.getExtras();
		String tid = bundle.getString("tid");
		Log.v("tid",tid);
		newthread = (TextView)this.findViewById(R.id.tv_newthread);
		reply     = (TextView)this.findViewById(R.id.tv_reply);
		cListView = (ContentListView)this.findViewById(R.id.contentListView);
		String url = "http://www.oiegg.com/wap/index.php?action=thread&showall=true&tid=" + tid;
		cListView.setUsewap(true);
		cListView.setUrl(url);
		String regex = "<li>(.*)<small>(.*)</small>.*</li>";
		cListView.setRegex(regex);
		cListView.list();
		newthread.setOnClickListener(new TvOnClickListener());
		reply.setOnClickListener(new TvOnClickListener());
		
	}
	class TvOnClickListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			if(id == R.id.tv_newthread){
				
			}else if(id == R.id.tv_reply){
				Intent intent = new Intent();
				intent.setClass(ContentActivity.this, ReplyActivity.class);
				ContentActivity.this.startActivity(intent);
			}
		}
		
	}
}
