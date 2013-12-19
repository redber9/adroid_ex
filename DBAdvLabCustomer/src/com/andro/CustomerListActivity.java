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
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomerListActivity extends Activity implements OnClickListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   
        setContentView(R.layout.query);
        LinearLayout layout = (LinearLayout) findViewById(R.id.customers);
        
        try {
        	// DBManager ��ü ����(DB ���� ������ ����)
        	DBManager dbmgr = new DBManager(this);
	        
        	// DB ����
	        SQLiteDatabase sdb = dbmgr.getReadableDatabase();
	        // SQL�� ���� ����� cursor ��ü�� ���� 
	        String sql = "select name, sex, sms, interest " + 
	                     "  from customers ";
	        Cursor cursor = sdb.rawQuery(sql, null);
	        
	        int i=0;
	        
	        // cursor ��ü�� �Ҵ�� members ���̺� �����͸� �� �྿ �̵��ϸ鼭 �����
	        while(cursor.moveToNext()) {
	        	// ���� ù ��° ��(0), ..., �� ��° ��(3)�� ���� ������  
	        	String name     = cursor.getString(0);
	        	String sex      = cursor.getString(1);
	        	String sms      = cursor.getString(2);
	        	String interest = cursor.getString(3);
	        	
	            TextView tv_list = new TextView(this);

	        	// TextView�� �����͸� �߰��ϸ鼭 �����
	        	tv_list.append(name);
	        	tv_list.setTextSize(20);
	        	tv_list.setTextColor(Color.rgb(255, 255, 0));
	        	tv_list.setBackgroundColor(Color.rgb(0, 0, 255));
	            layout.addView(tv_list);
	            
	            tv_list.setId(i);
	            tv_list.setOnClickListener(this);
	            tv_list.setTag(name);
	        	  
	            TextView tv_list2 = new TextView(this);

	        	// TextView�� �����͸� �߰��ϸ鼭 �����
	        	tv_list2.append(sex  + "\n");
	        	tv_list2.append(sms  + "\n");
	        	tv_list2.append(interest);
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
    }

    // '���' ��ư�� Ŭ���Ǿ��� ��
    public void onClick(View v) {
    	Intent it = new Intent(); 
    	// ���� Ŭ����(this)���� ȣ���� Ŭ����(JoinLabActivity.class) ���� 
		it    = new Intent(this, CustomerDetailActivity.class);
        // �Է��� ������ ���� ���� 
        it.putExtra("it_name", (String)v.getTag());
		
		// ����Ʈ���� ������ ��Ƽ��Ƽ ���� 
		startActivity(it);
		// ���� ��Ƽ��Ƽ ���� 
		finish();
    }    
}