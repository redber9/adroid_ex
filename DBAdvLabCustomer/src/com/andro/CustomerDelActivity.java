package com.andro;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

public class CustomerDelActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // ������ ������ ����Ʈ�� ���� 
        Intent it = getIntent();

        ///// ����Ʈ�κ��� ��������: ����  
        // ����Ʈ�κ��� send_name�� ���� ������ 
        String str_name = it.getStringExtra("it_name");
        
        String sql = "";
        
        try {
        	// DB��ü ����(DB�� �������� ������ ������)
        	DBManager dbmgr = new DBManager(this);
        
            SQLiteDatabase sdb;
            
            // DB����
            sdb = dbmgr.getWritableDatabase();
            // members ���̺� �������� �߰�
            sql = "delete from customers " +
                  " where name = '" + str_name + "' ";  
            sdb.execSQL(sql);
            // DB����
            dbmgr.close();
        } catch (SQLiteException e) {
        	// ����ó��(����)
        }    	
    	
    	// ���� Ŭ����(This)���� ȣ���� Ŭ����(QueryActivity.class) ���� 
		Intent it2    = new Intent(this, TabViewActivity.class);
		// ����Ʈ���� ������ ��Ƽ��Ƽ ����  
		startActivity(it2);
		// ���� ��Ƽ��Ƽ ����
		finish();
    }
}