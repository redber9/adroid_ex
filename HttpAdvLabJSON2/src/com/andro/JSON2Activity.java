package com.andro;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class JSON2Activity extends Activity implements OnClickListener {
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
		
		// ������ ��� ���� �ν�
		EditText et_webpage_src = (EditText)findViewById(R.id.webpage_src);

		URL url = null;
		HttpURLConnection urlConnection = null;
		BufferedInputStream buf = null;
		
		try {    
			///// URL ������ ���� 
			// ������ URL ���� 
			url = new URL("http://�� �κ��� ���� �����θ�(�Ǵ� IP)�� ���� �ּ���/json/customers.html");  
			// URL ����
			urlConnection = (HttpURLConnection) url.openConnection(); 
			
			///// ������ �ҽ��� ���ۿ� ����  
            // ������ �ٿ�ε�  			
			buf  = new BufferedInputStream(urlConnection.getInputStream());    
			// �����͸� ���ۿ� ��� 
        	BufferedReader bufreader = new BufferedReader(new InputStreamReader(buf, "utf-8"));
        	
        	String line  = null;
        	String page  = "";
        	
        	// ������ ������ �ҽ��� �� ������ �о�(line), page�� ������ 
        	while ((line = bufreader.readLine()) != null) {
        		page += line;
        	}
        	
	        // �о���� JSON ������ ���̾�Ʋ JSON ��ü�� ��ȯ
    		JSONObject json = new JSONObject(page);
    		// customers�� �ش��ϴ� �迭�� �Ҵ�  
    		JSONArray  jArr = json.getJSONArray("customers");
    		
    		// �迭�� ũ�⸸ŭ �ݺ��ϸ鼭, name�� address�� ���� ������ 
    		for (int i=0; i<jArr.length(); i++) {
    			
    			// i��° �迭 �Ҵ�  
        		json = jArr.getJSONObject(i);
        		
        		// name�� address�� ���� ������
        		String name    = json.getString("name");
        		String address = json.getString("address");
        		
        		// name�� address�� ���� �����
    			et_webpage_src.append(name + "\n");
    			et_webpage_src.append(address + "\n");
    		}
    		
    		
        } catch (Exception e){
        	// �����޽��� ��� 
        	et_webpage_src.setText(e.getMessage());
		} finally {   
			// URL ���� ����
			urlConnection.disconnect();  
		}			
    }
}