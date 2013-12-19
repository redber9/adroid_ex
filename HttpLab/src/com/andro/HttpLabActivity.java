package com.andro;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HttpLabActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // ��ư Ŭ�� ���: ���� 
        Button btn = (Button)findViewById(R.id.button_call);
        btn.setOnClickListener(this);
        // ��ư Ŭ�� ���: �� 
    }

	// @Override
	public void onClick(View v) {
		
		// �Է� URL ���� �ν� �� URL ����
		EditText et_url  = (EditText)findViewById(R.id.url);
		String   str_url = (et_url.getText()).toString();
		// ������ �ҽ� ��¿��� �ν�
		EditText et_webpage_src = (EditText)findViewById(R.id.webpage_src);
		
		URL url = null;
		HttpURLConnection urlConnection = null;
		BufferedInputStream buf = null;
		
		try {     
    		///// URL ������ ���� 
			// ������ URL ���� 
			url = new URL(str_url);  
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
        	
        	// ������ �ҽ��� ��� 
			et_webpage_src.append(page);
    		
        } catch (Exception e){
        	// ���ܻ��� ��� 
        	et_webpage_src.append(e.getMessage());
		} finally {  
			// URL ���� ����
			urlConnection.disconnect();  
		}
	}
}