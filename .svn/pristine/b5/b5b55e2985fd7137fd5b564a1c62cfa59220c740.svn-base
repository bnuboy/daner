/**
 * 首页导航文件，师大，信息，生涯，职业，娱乐等
 */
package com.bnuboy.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bnuboy.second.SecondListActivity;
import com.bnuboy.topten.ToptenListActivity;
import com.example.daner.MainActivity;
import com.example.daner.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class IndexNav{
	private TextView bnu;
	private TextView infomation;
	private TextView career;
	private TextView life;
	private TextView academic;
	private TextView trade;
	private TextView entertainment;
	private TextView club;
	private TextView topten;
	public MainActivity act;
	
	public IndexNav(MainActivity ma){
		this.act = ma;
		act.setContentView(R.layout.indexnav);
		NavListener navListener = new NavListener();
		topten        = (TextView)act.findViewById(R.id.topten);
		bnu           = (TextView)act.findViewById(R.id.bnu);
        infomation    = (TextView)act.findViewById(R.id.infomation);
        career        = (TextView)act.findViewById(R.id.career);
        academic      = (TextView)act.findViewById(R.id.academic);
        trade         = (TextView)act.findViewById(R.id.trade);
        life		  = (TextView)act.findViewById(R.id.life);
        entertainment = (TextView)act.findViewById(R.id.entertainment);
        club          = (TextView)act.findViewById(R.id.club);
        topten.setOnClickListener(navListener);
        bnu.setOnClickListener(navListener);
        infomation.setOnClickListener(navListener);
        career.setOnClickListener(navListener);
        academic.setOnClickListener(navListener);
        trade.setOnClickListener(navListener);
        life.setOnClickListener(navListener);
        entertainment.setOnClickListener(navListener);
        club.setOnClickListener(navListener);
	}
	class NavListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			Bundle bundle = new Bundle();
			Intent intent = new Intent(act,SecondListActivity.class);
			List<Map<String,String>> list = new ArrayList<Map<String,String>>();
			if(id == R.id.topten){
				//Intent intent = new Intent(act,ToptenListActivity.class);
				intent.setClass(act,ToptenListActivity.class);
				act.startActivity(intent);
			}else if(id == R.id.bnu){
				bundle.putString("gid", "169");
			}else if(id == R.id.infomation){
				bundle.putString("gid", "546");
			}else if(id == R.id.career){
				bundle.putString("gid", "794");
			}else if(id == R.id.academic){
				bundle.putString("gid", "495");
			}else if(id == R.id.trade){
				bundle.putString("gid", "632");
			}else if(id == R.id.life){
				bundle.putString("gid", "544");
			}else if(id == R.id.entertainment){
				bundle.putString("gid","41");
			}else if(id == R.id.club){
				bundle.putString("gid","608");
			}
			intent.putExtras(bundle);
			act.startActivity(intent);
		}
    	
    }
}
