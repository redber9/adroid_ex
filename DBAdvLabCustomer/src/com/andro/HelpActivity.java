package com.andro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends Activity {    
	public void onCreate(Bundle savedInstanceState) {        
		super.onCreate(savedInstanceState);  
		
		TextView textview = new TextView(this);        
		textview.setText("�������ý��� V1.0");        
		setContentView(textview);    
    }
}