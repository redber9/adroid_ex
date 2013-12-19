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

public class CustomerDetailActivity extends Activity implements OnClickListener {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.query_detail);
        
        // ���������� �߰��� ���̾ƿ��� �ν���  
        LinearLayout layout = (LinearLayout) findViewById(R.id.customer_detail);
        
        // ������ ������ ����Ʈ�� ���� 
        Intent it    = getIntent();
        // ����Ʈ�κ��� send_name�� ���� ������ 
        String str_name = it.getStringExtra("it_name");
        
        String name = "";
        try {
        	// DBManager ��ü ����(DB ���� ������ ����)
        	DBManager dbmgr = new DBManager(this);
	        
        	// DB ����
	        SQLiteDatabase sdb = dbmgr.getReadableDatabase();
	        // SQL�� ���� ����� cursor ��ü�� ���� 
	        String sql = "select name, sex, sms " + 
	                     "  from customers" +
	        		     " where name = '" + str_name + "' ";
	        Cursor cursor = sdb.rawQuery(sql, null);
	        
	        // cursor ��ü�� �Ҵ�� members ���̺� �����͸� �� �྿ �̵��ϸ鼭 �����
	       if (cursor.moveToNext()) {
	        	// ���� ù ��° ��(0), ..., �� ��° ��(3)�� ���� ������  
	        	name     = cursor.getString(0);
	        	String sex      = cursor.getString(1);
	        	String sms      = cursor.getString(2);
	        	
	        	// ���̾ƿ��� �߰��� ��������(����)�� ���� �ؽ�Ʈ�� ����
	            TextView tv_list = new TextView(this);

	        	// �ؽ�Ʈ�信 �������� �Ҵ�
	        	tv_list.append(name);
	        	tv_list.setTextSize(20);
	        	tv_list.setTextColor(Color.rgb(255, 255, 0));
	        	tv_list.setBackgroundColor(Color.rgb(0, 0, 255));
	        	// ���������� ���̾ƿ��� �߰��Ͽ� ��¾�
	            layout.addView(tv_list);
	        	  
	        	// ���̾ƿ��� �߰��� ��������(����, ���ſ���)�� ���� �ؽ�Ʈ�� ����
	            TextView tv_list2 = new TextView(this);

	        	// �ؽ�Ʈ�信 ������ ������ ���ſ��� �Ҵ�
	        	tv_list2.append(sex  + "\n");
	        	tv_list2.append(sms  + "\n");
	        	// ���������� ���̾ƿ��� �߰��Ͽ� ��¾�
	            layout.addView(tv_list2);
	        }
	        	
	        // cursor ��ü ����
	        cursor.close();
	        // dbmgr ��ü ����
	        dbmgr.close();
        
        } catch (SQLiteException e) {
        	// DB ���� �Ǵ� ��ȸ �� ���� �߻��� �� 
            TextView tv_err = new TextView(this);
            // tv_desc.append("��ϵ� ������ �����ϴ�!");
            tv_err.append(e.getMessage());
            layout.addView(tv_err);	        	
        }
        
        // ID�� button_join_form(main.xml)�� ��ư �ʱ�ȭ
        Button btn_update_form = (Button)findViewById(R.id.button_update_form);
        // '���' ��ư Ŭ�� ���
        btn_update_form.setOnClickListener(this);
        btn_update_form.setTag(name);
        
        // ID�� button_join_form(main.xml)�� ��ư �ʱ�ȭ
        Button btn_delete = (Button)findViewById(R.id.button_delete);
        // '���' ��ư Ŭ�� ���
        btn_delete.setOnClickListener(this);
        btn_delete.setTag(name);
        
        // ID�� button_join_form(main.xml)�� ��ư �ʱ�ȭ
        Button btn_list = (Button)findViewById(R.id.button_list_from_detail);
        // '���' ��ư Ŭ�� ���
        btn_list.setOnClickListener(this);
        btn_list.setTag(name);
    }

    // ��ư�� Ŭ���Ǿ��� ��
    public void onClick(View v) {
    	Intent it = new Intent();
    	
    	// '����' ��ư Ŭ�� ��
    	if (v.getId() == R.id.button_update_form) {
	    	// ���� Ŭ����(this)���� ȣ���� Ŭ����(JoinLabActivity.class) ���� 
			it    = new Intent(this, CustomerModActivity.class);
	        // �Է��� ������ ���� ���� 
	        it.putExtra("it_name", (String)v.getTag());
	    // '����' ��ư Ŭ�� ��     
    	} else if (v.getId() == R.id.button_delete) {
	    	// ���� Ŭ����(this)���� ȣ���� Ŭ����(JoinLabActivity.class) ���� 
			it    = new Intent(this, CustomerDelActivity.class);
	        // �Է��� ������ ���� ���� 
	        it.putExtra("it_name", (String)v.getTag());
	    // '���' ��ư Ŭ�� ��     
		} else if (v.getId() == R.id.button_list_from_detail) {
	    	// ���� Ŭ����(this)���� ȣ���� Ŭ����(JoinLabActivity.class) ���� 
			it    = new Intent(this, CustomerListActivity.class);
		}
		// ����Ʈ���� ������ ��Ƽ��Ƽ ���� 
		startActivity(it);
		// ���� ��Ƽ��Ƽ ���� 
		finish();
    }    
}