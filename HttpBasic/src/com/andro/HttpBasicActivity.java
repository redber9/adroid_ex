package com.andro;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class HttpBasicActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // ������ �ҽ� ��� ���� �ν�
		EditText et_webpage_src = (EditText)findViewById(R.id.webpage_src);
		
		URL url = null;
		HttpURLConnection urlConnection = null;
		BufferedInputStream buf = null;
		
		try {    
			///// URL ������ ���� 
			// ������ URL ���� 
			url = new URL("http://www.google.co.kr/");  
			// URL ����
			urlConnection = (HttpURLConnection) url.openConnection(); 
			
			///// ������ �ҽ��� ���ۿ� ����  
            // ������ �ٿ�ε�  			
			buf  = new BufferedInputStream(urlConnection.getInputStream());    
			// �����͸� ���ۿ� ��� 
        	BufferedReader bufreader = new BufferedReader(new InputStreamReader(buf, "euc-kr"));
        	
        	String line  = null;
        	String page  = "";
        	
        	// ������ ������ �ҽ��� �� ������ �о�(line), page�� ������ 
        	while ((line = bufreader.readLine()) != null) {
        		page += line;
        	}
        	
        	// page ������ ȭ�鿡  ���
        	et_webpage_src.setText(page);
        	
        } catch (Exception e){
        	// ���ܻ��� �߻� �� ��� 
        	et_webpage_src.setText(e.getMessage());
		} finally {   
			// URL ���� ����
			urlConnection.disconnect();  
		}		
	}
}