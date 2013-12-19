package com.andro;

import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class CustomerRegActivity extends Activity implements OnClickListener {
	
	private DBManager dbmgr;
	Spinner spinner;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_form);
 
        spinner = (Spinner) findViewById(R.id.spinner_interest);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(            
        	this, R.array.interest_array, android.R.layout.simple_spinner_item);    
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);    
        spinner.setAdapter(adapter); 
        
     // ID�� Button_Store�� ��ư �ν� �� Ŭ�� ���, OnClick()�޼ҵ� ����   
        Button btn = (Button)findViewById(R.id.button_store);
        btn.setOnClickListener(this);
    }
    
    public void onClick(View v) {

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
		
		// ���ɺо� ���� 
		String str_interest = spinner.getSelectedItem().toString();
		
        try {
        	// DB��ü ����(DB�� �������� ������ ������)
            dbmgr = new DBManager(this);
            
            SQLiteDatabase sdb;
            
            // DB����
            sdb = dbmgr.getWritableDatabase();
            // members ���̺� �������� �߰�
            sdb.execSQL("insert into customers values('" + str_name + "', '" + str_sex + "', '" + str_sms + "', '" + str_interest + "');");
            // DB����
            dbmgr.close();
        } catch (SQLiteException e) {
        	// ����ó��(����)
        }    	
    	
    	// ���� Ŭ����(This)���� ȣ���� Ŭ����(QueryActivity.class) ���� 
		Intent it    = new Intent(this, TabViewActivity.class);
		// ����Ʈ���� ������ ��Ƽ��Ƽ ����  
		startActivity(it);
		// ���� ��Ƽ��Ƽ ����
		finish();
    }    
}