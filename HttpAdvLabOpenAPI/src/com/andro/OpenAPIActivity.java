package com.andro;

import java.net.URL;
import java.net.URLEncoder;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OpenAPIActivity extends Activity implements OnClickListener {
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
	    	// �뼱��ȣ�����ȸ URL
			String serviceUrl = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList";
			// ���ﱳ���������� OPen API ����Ű 
			String serviceKey = "�� �κ��� Open API ����Ű�� ��ü�ϼ���"; 
			// ���� Ű�� URL ���ڵ�
			serviceKey = URLEncoder.encode(serviceKey);
			// �˻��� ���� �뼱��ȣ 
			String strSrch = "5500";
			// �뼱��ȣ�����ȸ ��û URL
			String strURL = serviceUrl+"?ServiceKey="+serviceKey+"&strSrch="+strSrch;
	    	// �� ���� ���ҽ� ����
	        URL url = new URL(strURL);
			
	        // XML Pull Parser�� ����� ���� XmlPullParserFactory�� �ν��Ͻ� ���� 
	        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
	        // XML Pull Parser�� �ν��Ͻ� ���� 
	        XmlPullParser parser = factory.newPullParser();
	        // �� ���ҽ��� ���� Input Stream ���� 
	        parser.setInput(url.openStream(), "utf-8");
	        
            // ���� �̺�Ʈ Ÿ��(START_TAG, END_TAG, TEXT, etc)�� ��ȯ��	        
	        int eventType = parser.getEventType();
	        // �±� �̸�(<busRouteNm>, <stStationNm>, <edStationNm>)�� �˻����� �ʱ�ġ 
	        boolean bSet = false;
	        
	        // �̺�Ʈ Ÿ���� ��ť��Ʈ�� �������� �ƴϸ� �ݺ� 
	        while (eventType != XmlPullParser.END_DOCUMENT) {
	        	
	            switch (eventType) {
	            
	                // �̺�Ʈ Ÿ���� ��ť��Ʈ�� ������ ���
	                case XmlPullParser.START_DOCUMENT:
	                    break;
	                    
	                // �̺�Ʈ Ÿ���� START_TAG�� ���(��: <busRouteNm>)
	                case XmlPullParser.START_TAG:
	                	// �±� �̸��� ������
	                    String tag = parser.getName();
	                    // �±� �̸��� <busRouteNm>, <stStationNm>, <edStationNm>�� ���  
	                    if (tag.equals("busRouteNm") || tag.equals("stStationNm") || tag.equals("edStationNm")) {
	                        bSet = true;
	                    }
	                    break;
	                    
	                // �̺�Ʈ Ÿ���� END_TAG�� ���(��: </busRouteNm>)    
	                case XmlPullParser.END_TAG:
	                    break;
	                    
	                // �̺�Ʈ Ÿ���� �±� ������ �������� ���� ������ ���� (��: <busRouteNm>������</busRouteNm>)       
	                case XmlPullParser.TEXT:
	                	// �±�(<busRouteNm>, <stStationNm>, <edStationNm>) ������ ������ ����
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
	                    
	            } // switch
	            
	            // ���� �̺�Ʈ Ÿ���� �Ҵ� 
	            eventType = parser.next();
	            
	        } // while
	    } catch (Exception e) {
	    	// �޽��� ���
	        Toast.makeText(v.getContext(), e.getMessage(), 0).show();
	    } // try 
    }
}