package com.andro;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class CustomerRegActivity extends Activity implements OnClickListener {
	
	private DBManager dbmgr;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_form);
        
        setTitle("�����");
 
        // ID�� Button_Store�� ��ư �ν� �� Ŭ�� ���, OnClick()�޼ҵ� ����   
        Button btn_store = (Button)findViewById(R.id.button_store);
        btn_store.setOnClickListener(this);
        
        // ID�� Button_list�� ��ư �ν� �� Ŭ�� ���, OnClick()�޼ҵ� ����   
        Button btn_list = (Button)findViewById(R.id.button_list);
        btn_list.setOnClickListener(this);
    }
    
    public void onClick(View v) {
    	
    	// '���' ��ư�� Ŭ���� ���, ��������� �̵� 
    	if (v.getId() == R.id.button_list) {
	    	// ���� Ŭ�������� ȣ���� Ŭ���� ���� 
			Intent it    = new Intent(this, CustomerListActivity.class);
			// ����Ʈ���� ������ ��Ƽ��Ƽ ����  
			startActivity(it);
			// ���� ��Ƽ��Ƽ ����
			finish();
    	}
    	
       	// ���� ����
    	EditText et_name = (EditText)findViewById(R.id.edit_name);
		String str_name = et_name.getText().toString();
		
		// ���� ����
		RadioGroup rg_sex = (RadioGroup)findViewById(R.id.radiogroup_sex);
		String str_sex = "";
		if (rg_sex.getCheckedRadioButtonId() == R.id.radio_male) {
		    str_sex = "��";	
		}
		if (rg_sex.getCheckedRadioButtonId() == R.id.radio_female) {
		    str_sex = "��";	
		}
		
		// ���ſ��� ���� 
		CheckBox   chk_sms = (CheckBox)findViewById(R.id.check_sms);
		String str_sms = "";
		if (chk_sms.isChecked()) {
		    str_sms = (String)chk_sms.getText();	
		}
		
        try {
        	// DB��ü ����(DB�� �������� ������ ������)
            dbmgr = new DBManager(this);
            
            SQLiteDatabase sdb;
            
            // DB����
            sdb = dbmgr.getWritableDatabase();
            // members ���̺� �������� �߰�
            sdb.execSQL("insert into customers values('" + str_name + "', '" + str_sex + "', '" + str_sms + "');");
            // DB����
            dbmgr.close();
        } catch (SQLiteException e) {
        	// ����ó��(����)
        }    	
    	
    	// ���� Ŭ����(This)���� ȣ���� Ŭ����(QueryActivity.class) ���� 
		Intent it    = new Intent(this, CustomerListActivity.class);
		// ����Ʈ���� ������ ��Ƽ��Ƽ ����  
		startActivity(it);
		// ���� ��Ƽ��Ƽ ����
		finish();
    }    
}