package com.andro;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomerListActivity extends Activity implements OnClickListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.main);
        
        // ��Ƽ��Ƽ �� ��� 
        setTitle("�����");
        
        // �������� �߰��� ���̾ƿ��� �ν���  
        LinearLayout layout = (LinearLayout) findViewById(R.id.customers);
        
        int i=0;
        
        try {
        	// DBManager ��ü ����(DB ���� ������ ����)
        	DBManager dbmgr = new DBManager(this);
	        
        	// DB ����
	        SQLiteDatabase sdb = dbmgr.getReadableDatabase();
	        // SQL�� ���� ����� cursor ��ü�� ���� 
	        Cursor cursor = sdb.rawQuery("select name, sex, sms from customers", null);
	        
	        // cursor ��ü�� �Ҵ�� members ���̺� �����͸� �� �྿ �̵��ϸ鼭 �����
	        while(cursor.moveToNext()) {
	        	// ���� ù ��° ��(0), �� ��° ��(1), �� ��° ��(2)�� ���� ������  
	        	String name     = cursor.getString(0);
	        	String sex      = cursor.getString(1);
	        	String sms      = cursor.getString(2);
	        	
	        	// ���̾ƿ��� �߰��� ������(����)�� ���� �ؽ�Ʈ�� ����
	            TextView tv_list = new TextView(this);

	        	// �ؽ�Ʈ�信 ������ �Ҵ�
	        	tv_list.append(name);
	        	tv_list.setTextSize(20);
	        	tv_list.setTextColor(Color.rgb(255, 255, 0));
	        	tv_list.setBackgroundColor(Color.rgb(0, 0, 255));
	        	// �������� ���̾ƿ��� �߰��Ͽ� ��¾�
	            layout.addView(tv_list);
	            
	            // �������� ���� Ŭ�������� ����
	            tv_list.setId(i);
	            tv_list.setOnClickListener(this);
	            tv_list.setTag(name);
	        	  
	        	// ���̾ƿ��� �߰��� ������(����, ���ſ���)�� ���� �ؽ�Ʈ�� ����
	            TextView tv_list2 = new TextView(this);

	        	// �ؽ�Ʈ�信 ���� ������ ���ſ��� �Ҵ�
	        	tv_list2.append(sex  + "\n");
	        	tv_list2.append(sms  + "\n");
	        	// �������� ���̾ƿ��� �߰��Ͽ� ��¾�
	            layout.addView(tv_list2);
	            
	        	i++;
	        }
	        
	        // ��ϵ� ���� ���� ����� ����
	        if (i == 0) {
	            TextView tv_desc = new TextView(this);
	            tv_desc.append("��ϵ� ���� �����ϴ�!");
	            layout.addView(tv_desc);	        	
	        }
	        	
	        // cursor ��ü ����
	        cursor.close();
	        // dbmgr ��ü ����
	        dbmgr.close();
        
        } catch (SQLiteException e) {
        	// DB ���� �Ǵ� ��ȸ �� ���� �߻��� �� 
            TextView tv_err = new TextView(this);
            // tv_desc.append("��ϵ� ���� �����ϴ�!");
            tv_err.append(e.getMessage());
            layout.addView(tv_err);	        	
        }
        
        // ID�� button_join_form(main.xml)�� ��ư �ʱ�ȭ
        Button btn = (Button)findViewById(R.id.button_join_form);
        // '���' ��ư Ŭ�� ���
        btn.setOnClickListener(this);
    }

    // '���' ��ư�� Ŭ���Ǿ��� ��
    public void onClick(View v) {
    	Intent it = new Intent(); 
        
    	// '���' ��ư Ŭ�� ��
    	if (v.getId() == R.id.button_join_form) {
	    	// ���� Ŭ�������� ȣ���� Ŭ���� ���� 
			it    = new Intent(this, CustomerRegActivity.class);
    	} else {
	    	// ���� Ŭ�������� ȣ���� Ŭ���� ���� 
			it    = new Intent(this, CustomerDetailActivity.class);
	        // �Է��� ������ ���� ���� 
	        it.putExtra("it_name", (String)v.getTag());
    	}
		
		// ����Ʈ���� ������ ��Ƽ��Ƽ ���� 
		startActivity(it);
		// ���� ��Ƽ��Ƽ ���� 
		finish();
    }    
}