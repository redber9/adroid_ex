package com.andro;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class CustomerModActivity extends Activity implements OnClickListener {
	
	private DBManager dbmgr;
	Spinner spinner;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_form);
 
        spinner = (Spinner) findViewById(R.id.spinner_interest);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(            
        	this, R.array.interest_array, android.R.layout.simple_spinner_item);    
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);    
        spinner.setAdapter(adapter); 
        
        // ID�� Button_Store�� ��ư �ν� �� Ŭ�� ���, OnClick()�޼ҵ� ����   
        Button btn_previous = (Button)findViewById(R.id.button_previous);
        btn_previous.setOnClickListener(this);
        
        // ID�� Button_Store�� ��ư �ν� �� Ŭ�� ���, OnClick()�޼ҵ� ����   
        Button btn_store = (Button)findViewById(R.id.button_store);
        btn_store.setOnClickListener(this);
        
        // ��ϵ� ȸ������ ���: ����  ////////////////////////////
        
        // ������ ������ ����Ʈ�� ���� 
        Intent it    = getIntent();

        ///// ����Ʈ�κ��� ��������: ����  
        // ����Ʈ�κ��� send_name�� ���� ������ 
        String str_name = it.getStringExtra("it_name");
        
        try {
        	// DBManager ��ü ����(DB ���� ������ ����)
        	DBManager dbmgr = new DBManager(this);
	        
        	// DB ����
	        SQLiteDatabase sdb = dbmgr.getReadableDatabase();
	        // SQL�� ���� ����� cursor ��ü�� ���� 
	        String sql = "select name, sex, sms, interest " + 
	                     "  from customers " +
	        		     " where name = '" + str_name + "' ";
	        Cursor cursor = sdb.rawQuery(sql, null);
	        
	        // cursor ��ü�� �Ҵ�� members ���̺� �����͸� �� �྿ �̵��ϸ鼭 �����
	       if (cursor.moveToNext()) {
	        	// ���� ù ��° ��(0), ..., �� ��° ��(3)�� ���� ������  
	        	String name     = cursor.getString(0);
	        	String sex      = cursor.getString(1);
	        	String sms      = cursor.getString(2);
	        	String interest = cursor.getString(3);
	        	
	           	// ���� ����
	        	EditText et_name = (EditText)findViewById(R.id.edit_name);
	    		et_name.setText(name);
	    		
	    		RadioButton rb_sex = null; 
	    		if (sex.equals("��")) 
	    			rb_sex = (RadioButton)findViewById(R.id.radio_male);
	    		else if (sex.equals("��")) 
	    			rb_sex = (RadioButton)findViewById(R.id.radio_female);
    			rb_sex.setChecked(true);
    			
    			// ���ſ��� ���� 
    			CheckBox   chk_sms = (CheckBox)findViewById(R.id.check_sms);
    			if (sms.equals("SMS")) 
    				chk_sms.setChecked(true);	
    			
    			// ���� ���ɺξ߿� ��ġ�ϴ� ���ǳ� ������ ����
    			String spinner_item_name;
    			for (int i=0; i<spinner.getCount(); i++) {
    				// i��° ���ǳ� ������ ��
    				spinner_item_name = (String)spinner.getItemAtPosition(i);
    				// ���� ���ɺξ߿� i��° ���ǳ� ������ ���� ��ġ�ϸ� i��° ���ǳ� �������� ����
    			    if (interest.equals(spinner_item_name)) 
    				    spinner.setSelection(i);
    			}
	        }
	        	
	        // cursor ��ü ����
	        cursor.close();
	        // dbmgr ��ü ����
	        dbmgr.close();
        
        } catch (SQLiteException e) {
        	// DB ���� �Ǵ� ��ȸ �� ���� �߻��� �� 
        }
                
        // ��ϵ� ȸ������ ���: ��  ////////////////////////////
    }
    
    public void onClick(View v) {
    	
    	if (v.getId() == R.id.button_store) {

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
	            String sql = "update customers " +
	                         "   set sex  = '" + str_sex  + "', " +
	                         "       sms  = '" + str_sms  + "', " +
	            		     "       interest = '" + str_interest + "' " +
	                         " where name = '" + str_name + "' ";
	            sdb.execSQL(sql);
	            // DB����
	            dbmgr.close();
	        } catch (SQLiteException e) {
	        	// ����ó��(����)
	        } // try   	
        
    	}
    	
    	// ���� Ŭ����(This)���� ȣ���� Ŭ����(QueryActivity.class) ���� 
		Intent it    = new Intent(this, TabViewActivity.class);
		// ����Ʈ���� ������ ��Ƽ��Ƽ ����  
		startActivity(it);
		// ���� ��Ƽ��Ƽ ����
		finish();
    }    
}