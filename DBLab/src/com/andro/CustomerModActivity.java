package com.andro;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class CustomerModActivity extends Activity implements OnClickListener {
	
	private DBManager dbmgr;
	Spinner spinner;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_form);
 
        // ID�� Button_Store�� ��ư �ν� �� Ŭ�� ���, OnClick()�޼ҵ� ����   
        Button btn = (Button)findViewById(R.id.button_store);
        btn.setOnClickListener(this);
        
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
	        String sql = "select name, sex, sms " + 
	                     "  from customers" +
	        		     " where name = '" + str_name + "' ";
	        Cursor cursor = sdb.rawQuery(sql, null);
	        
	        // cursor ��ü�� �Ҵ�� members ���̺� �����͸� �� �྿ �̵��ϸ鼭 �����
	       if (cursor.moveToNext()) {
	        	// ���� ù ��° ��(0), ..., �� ��° ��(3)�� ���� ������  
	        	String name     = cursor.getString(0);
	        	String sex      = cursor.getString(1);
	        	String sms      = cursor.getString(2);
	        	
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
            String sql = "update customers " +
                         "   set sex  = '" + str_sex  + "', " +
                         "       sms  = '" + str_sms  + "'  " +
                         " where name = '" + str_name + "' ";
            sdb.execSQL(sql);
            // DB����
            dbmgr.close();
        } catch (SQLiteException e) {
        	// ����ó��(����) 
        }    	
    	
    	// ���� Ŭ����(This)���� ȣ���� Ŭ����(QueryActivity.class) ���� 
		Intent it    = new Intent(this, CustomerDetailActivity.class);
        // �Է��� ������ ���� ���� 
        it.putExtra("it_name", str_name);
		// ����Ʈ���� ������ ��Ƽ��Ƽ ����  
		startActivity(it);
		// ���� ��Ƽ��Ƽ ����
		finish();
    }    
}