package com.andro;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class TabViewActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Resources res = getResources(); // ���ҽ� ��ü ����    
        TabHost tabHost = getTabHost();  // �Ǹ޴� ��Ƽ��Ƽ ����    
        TabHost.TabSpec spec;  // �� ���� �޴��� �������� ���� ��ü ����    
        Intent intent;  // �� �ǿ��� ����� ����Ʈ ����    
        
        // ����Ʈ ����    
        intent = new Intent().setClass(this, CustListActivity.class);    
        
        // �� ���� �޴��� �������� ���� ��ü ����
        spec = tabHost.newTabSpec("custList").setIndicator("����Ȳ").setContent(intent);    
        tabHost.addTab(spec);    
        
        intent = new Intent().setClass(this, CustRegActivity.class);    
        spec = tabHost.newTabSpec("custReg").setIndicator("�����").setContent(intent);    
        tabHost.addTab(spec);    
        
        intent = new Intent().setClass(this, CustHelpActivity.class);    
        spec = tabHost.newTabSpec("custHelp").setIndicator("����").setContent(intent);    
        tabHost.addTab(spec); 
        
        tabHost.setCurrentTab(0);
    }
}