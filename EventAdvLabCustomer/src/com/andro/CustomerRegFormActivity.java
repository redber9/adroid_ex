package com.andro;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class CustomerRegFormActivity extends Activity implements OnClickListener {
	private TextView mDateDisplay;    
	private int mYear;    
	private int mMonth;    
	private int mDay;    
	static final int DATE_DIALOG_ID = 0;	
	Spinner spinner;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ///// ���ǳ� ���: ���� 
        // (1) strings.xml�� ������ string �迭(interest_array)�� ArrayAdapter��  ���ε��ϰ� ���ǳ��� ����� ������ 
        ArrayAdapter<CharSequence> adapter = 
        	ArrayAdapter.createFromResource(this, R.array.interest_array, android.R.layout.simple_spinner_item);  
        // (2) ArrayAdapter��ü�� �Ҵ�� �����͵��� ���ǳʰ� Ŭ���� �� ������ ���ǳ� �������� ��������� ������  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // (3) main.xml�� ���ǳ� id �ν�
        spinner = (Spinner) findViewById(R.id.spinner_interest);
        // (4) ���ǳʿ� ArrayAdapter�� ������ 
        spinner.setAdapter(adapter);        
        ///// ���ǳ� ���: �� 
        
        //// Date Picker: ����  ////////////
        // (1) main.xml�� ���̾ƿ��� ��ġ�� ��¥ �Է��� ���� TextView �ν�          
        mDateDisplay = (TextView) findViewById(R.id.edit_birthday);        
        // (2) �νĵ� TextView�� click listener �߰�
        mDateDisplay.setOnClickListener(new View.OnClickListener() {  
        	// (5) Ŭ���Ǹ� ����  
        	public void onClick(View v) {   
        		// (6) ��¥ ������ ���� ���̾�α� ���
        		showDialog(DATE_DIALOG_ID);            
        	}        
        });        
        // (3) ���� ��¥ �ν�         
        final Calendar c = Calendar.getInstance();        
        mYear = c.get(Calendar.YEAR);        
        mMonth = c.get(Calendar.MONTH);        
        mDay = c.get(Calendar.DAY_OF_MONTH);        
        // (4) �νĵ� ��¥��  ���        
        updateDisplay();        
        //// Date Picker: ��  ////////////
        
        ///// ��ư Ŭ�� ���: ����
        // ID�� button_send(main.xml)�� ��ư�� �ʱ�ȭ 
        Button btn = (Button)findViewById(R.id.button_send);
        // ��ư Ŭ�� ���(Ŭ�� �� onClick() �޼ҵ尡 ȣ���) 
        btn.setOnClickListener(this);
        ///// ��ư Ŭ�� ��� ���: ��
        
    }
    
    // (7) ���̾�α� ��½� DatePicker ���̾�α� ��� 
    @Override
    protected Dialog onCreateDialog(int id) {    
    	switch (id) {    
	    	case DATE_DIALOG_ID:        
	    		return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);    
    	}    
    	return null;
   	}    
    
    // (8) ���̾�α׿� �ִ� ��¥�� ����(set)�ϸ� �����
    private DatePickerDialog.OnDateSetListener mDateSetListener =            
    	new DatePickerDialog.OnDateSetListener() {                
    	    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {                    
    		    mYear = year;                    
    		    mMonth = monthOfYear;                    
    		    mDay = dayOfMonth;
    		    // ����ڰ� ������ ��¥�� ��� 
    		    updateDisplay();                
    		}            
    	};    
    
    // ������ ��¥�� TextView�� ���     
    private void updateDisplay() {   
    	//main.xml�� ���̾ƿ��� ��ġ�� ��¥ �Է� TextView�� �νĵ� ��¥ ���     
    	mDateDisplay.setText(            
    		new StringBuilder()                    
    		// ���� �ý��ۿ��� 0~11�� �ν��ϱ� ������ 1�� ������
    		.append(mYear).append("-")
    		.append(mMonth + 1).append("-")                    
    		.append(mDay).append(" "));
    }   
    
    
	// ��ư Ŭ�� �� ���� 
	// @Override
    public void onClick(View v) {
    
	    ///// ���� ��ư Ŭ�� ��, ����ڰ� �Է��� ������ �˸�â�� ���: ���� 
        // ���� ����
        EditText et_name = (EditText)findViewById(R.id.edit_name);
        String str_name = et_name.getText().toString();

        // ���� ����        
        RadioGroup rg_sex = (RadioGroup)findViewById(R.id.radiogroup_sex);
        RadioButton rb_male = (RadioButton)findViewById(R.id.radio_male);
        RadioButton rb_female = (RadioButton)findViewById(R.id.radio_female);
        String str_sex = "";
        if (rg_sex.getCheckedRadioButtonId() == R.id.radio_male) {
            // str_sex = "��";	
            str_sex = rb_male.getText().toString();	
        }
        if (rg_sex.getCheckedRadioButtonId() == R.id.radio_female) {
            // str_sex = "��";	
            str_sex = rb_female.getText().toString();	
        }

        // ���ſ��� ���� 
        CheckBox   chk_sms = (CheckBox)findViewById(R.id.checkbox_sms);
        String str_sms = "";
        if (chk_sms.isChecked()) {
            str_sms = (String)chk_sms.getText();	
        }
        
        // ���ɺо� ���� 
        String str_interest = spinner.getSelectedItem().toString();
        
        // ���� ����
        EditText et_birthday = (EditText)findViewById(R.id.edit_birthday);
        String str_birthday = et_birthday.getText().toString();

        // �˸�â ��� 
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("�˸�â");
        alert.setMessage("����: " + str_name + "\n����: " + str_sex + "\n���ſ���: " + str_sms + "\n���ɺо�: " + str_interest + "\n����: " + str_birthday);
        alert.setIcon(R.drawable.ic_launcher);
        alert.setPositiveButton("Ȯ��", null);
        alert.show();
        ///// ���� ��ư Ŭ�� ��, ����ڰ� �Է��� ������ �˸�â�� ���: �� 
    }        
}