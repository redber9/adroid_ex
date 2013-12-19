package com.andro;

import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class XML2Activity extends Activity implements OnClickListener {
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
		
	    try {
	    	// ������ ���ҽ� ���� 
	        URL url = new URL("http://�� �κ��� ���� �����θ�(�Ǵ� IP)�� ���� �ּ���/xml/customers.xml");
			
	        // XML Pull Parser�� ����� ���� XmlPullParserFactory�� �ν��Ͻ� ���� 
	        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
	        // XML Pull Parser�� �ν��Ͻ� ���� 
	        XmlPullParser parser = factory.newPullParser();
	        // ������ ���ҽ��� ���� Input Stream ���� 
	        parser.setInput(url.openStream(), "utf-8");
	        
            // ���� �̺�Ʈ Ÿ��(START_TAG, END_TAG, TEXT, etc)�� ��ȯ��	        
	        int eventType = parser.getEventType();
	        // �±� �̸�(<name>, <address>)�� �˻����� �ʱ�ġ 
	        boolean bSet = false;
	        
	        // �̺�Ʈ Ÿ���� ��ť��Ʈ�� �������� �ƴϸ� �ݺ� 
	        while (eventType != XmlPullParser.END_DOCUMENT) {
	        	
	            switch (eventType) {
	            
                // �̺�Ʈ Ÿ���� ��ť��Ʈ�� ������ ���
	                case XmlPullParser.START_DOCUMENT:
	                    break;
	                    
		                // �̺�Ʈ Ÿ���� START_TAG�� ���(��: <name>)
	                case XmlPullParser.START_TAG:
	                	// �±� �̸��� ������
	                    String tag = parser.getName();
	                    // �±� �̸��� <name>, <address>�� ���  
	                    if (tag.equals("name") || tag.equals("address")) {
	                        bSet = true;
	                    }
	                    break;
	                    
	                // �̺�Ʈ Ÿ���� END_TAG�� ���(��: </name>)    
	                case XmlPullParser.END_TAG:
	                    break;
	                    
		                // �̺�Ʈ Ÿ���� �±� ������ �������� ���� ������ ���� (��: <name>������</name>)       
	                case XmlPullParser.TEXT:
	                	// �±�(<name>, <address>) ������ ������ ����
	                    if (bSet) {
	                    	// ������ ���� 
	                        String content = parser.getText();
	                        // ������ ��� 
	                        et_webpage_src.append(content + "\n");
	                        // �˻����� �ʱ�ġ �缳��
	                        bSet = false;
	                    }
	                    break;
	                    
			        // �̺�Ʈ Ÿ���� ��ť��Ʈ�� ���� ���
	                case XmlPullParser.END_DOCUMENT:
	                    break;
	                    
	            } 
	            
	            // ���� �̺�Ʈ Ÿ���� �Ҵ� 
	            eventType = parser.next();
	            
	        } 
	    } catch (Exception e) {
	        // ���ܻ��� �޽��� ���
	        Toast.makeText(v.getContext(), e.getMessage(), 0).show();
	    } 
    }
}