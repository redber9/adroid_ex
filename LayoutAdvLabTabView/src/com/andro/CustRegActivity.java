package com.andro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class CustRegActivity extends Activity {    
	public void onCreate(Bundle savedInstanceState) {        
		super.onCreate(savedInstanceState); 
		
		// ���� ��ü�� TextView ��ü ���� 
		TextView textview = new TextView(this);    
		// ����� ���� ���� 
		textview.setText("����� ȭ��");
		// ���� ��ü�� TextView ��ü���� ������ ���� ���  
		setContentView(textview);    
	}
}