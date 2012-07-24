package kr.PLAZMADev.KORAPN.free;

import android.app.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {
	ArrayAdapter<CharSequence> adspin;
	Button next;
	int swi;
	private static final String TAG = "OneClick APN";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Spinner spin = (Spinner)findViewById(R.id.country);
        spin.setPrompt("국가를 선택하세요.");
        
        adspin = ArrayAdapter.createFromResource(this, R.array.country,
        		android.R.layout.simple_spinner_dropdown_item);
        adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adspin);
        
        spin.setOnItemSelectedListener(new OnItemSelectedListener() {
        	public void onItemSelected(AdapterView<?> parent, View view,
        			int position, long id) {
        		String selItem = (String)spin.getSelectedItem();
        		if(selItem == "대한민국")
        			swi = 1;
        		else if(selItem == "미국")
        			swi = 2;
        		else if(selItem == "일본")
        			swi = 3;
        	}
        	public void onNothingSelected(AdapterView<?> parent) {
        	}
        });
        
        next = (Button)findViewById(R.id.Next1);
        next.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		switch(swi) {
        		case 1:
        			Toast.makeText(MainActivity.this, "대한민국 짱!", Toast.LENGTH_SHORT).show();
        			Log.v(TAG, "Korea Selected");
        			break;
        		case 2:
        			Toast.makeText(MainActivity.this, "미쿡 조아요!", Toast.LENGTH_SHORT).show();
        			Log.v(TAG, "America Selected");
        			break;
        		case 3:
        			Toast.makeText(MainActivity.this, "일본 좋습네다!", Toast.LENGTH_SHORT).show();
        			Log.v(TAG, "Japan Selected");
        			break;
        		default:
        			Toast.makeText(MainActivity.this, "나는 자연인이다!", Toast.LENGTH_SHORT).show();
        			Log.v(TAG, "Spinner Unji!");
        		}
        	}
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
