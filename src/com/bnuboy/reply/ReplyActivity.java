package com.bnuboy.reply;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.bnuboy.web.MyHttpPost;
import com.bnuboy.web.WebContent;
import com.example.daner.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ReplyActivity extends Activity {
	EditText et_message;
	Button   btn_reply;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_reply);
		btn_reply  = (Button) this.findViewById(R.id.btn_reply);
		et_message = (EditText)this.findViewById(R.id.et_message);
		btn_reply.setOnClickListener(new ReplyListener());
		
	}
	class ReplyListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			post();
		}
		
	}
	public void post(){
		String con = WebContent.getURLContent("http://www.oiegg.com/post.php?action=reply&fid=173&gid=544&tid=1296310&extra=", "UTF-8");
		int n = con.indexOf("formhash");
		Log.v("ffformhash", ""+n);
		String reges = "id=\"formhash\" value=\"(.*)\" />";
		Pattern p = Pattern.compile(reges);
		Matcher m = p.matcher(con);
		if(m.find()){
			String formhash = m.group(1);
			Log.v("vvvv",m.group(1));
		
		
			String message = et_message.getText().toString();
			MyHttpPost mhp = new MyHttpPost("http://www.oiegg.com/post.php?action=reply&amp;fid=506&amp;tid=1295514&amp;extra=&amp;replysubmit=yes");
			List <NameValuePair> params = new ArrayList <NameValuePair>();
			params.add(new BasicNameValuePair("formhash", formhash));
			params.add(new BasicNameValuePair("subject", "Good"));
			params.add(new BasicNameValuePair("message","My computer is bad???"));
			params.add(new BasicNameValuePair("mysiwyg", "1"));
			params.add(new BasicNameValuePair("fid", "506"));
			params.add(new BasicNameValuePair("replysubmit", "true"));
			mhp.setParams(params);
//			mhp.addParam("formhash", formhash);
//			mhp.addParam("subject", "Good");
//			mhp.addParam("message","My computer is bad???");
//			//mhp.addParam("localid[]", "1");
//			mhp.addParam("mysiwyg", "1");
//			mhp.addParam("fid", "506");
//			mhp.addParam("replysubmit", "true");
			mhp.post();
		}else{
			Log.v("not fined","not");
		}
	}
}
