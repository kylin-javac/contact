package com.example.contacts;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Spinner con;
	private LinearLayout ll;
	private TextView name;
	private TextView num;
	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		initData();

		con.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				HashMap<String, Object> map = (HashMap<String, Object>) parent
						.getItemAtPosition(position);
				int imgId = (Integer) map.get("img");
				String name1 = (String) map.get("name");
				String number1 = (String) map.get("number");
				ll.setVisibility(View.VISIBLE);
				image.setBackgroundResource(imgId);
				name.setText(name1);
				num.setText(number1);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}

	public void initData() {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 50; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("img", R.drawable.th_factortree);
			map.put("name", "ÕÅÈý" + i);
			map.put("number", "1888" + i);
			list.add(map);
		}
		String from[] = { "img", "name", "number" };
		int to[] = { R.id.im1, R.id.num1, R.id.name1 };
		SimpleAdapter adapter = new SimpleAdapter(this, list,
				R.layout.con_simpleadpter_item, from, to);
		con.setAdapter(adapter);
	}

	private void initView() {
		con = (Spinner) findViewById(R.id.con);
		ll = (LinearLayout) findViewById(R.id.ll);
		name = (TextView) findViewById(R.id.name);
		num = (TextView) findViewById(R.id.num);
		image = (ImageView) findViewById(R.id.image);
	}

}
