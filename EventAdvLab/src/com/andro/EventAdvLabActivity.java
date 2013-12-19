package com.andro;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.view.View.OnClickListener;

public class EventAdvLabActivity extends Activity implements OnClickListener {
	// ���ǳ� ��ü ����
	Spinner spinner;

	private TextView mDateDisplay;    
	private Button mPickDate;    
	private int mYear;    
	private int mMonth;    
	private int mDay;    
	static final int DATE_DIALOG_ID = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // ���ǳ� ���: ���� 
        spinner = (Spinner) findViewById(R.id.spinner_interest);
        ArrayAdapter<CharSequence> adapter = 
        	ArrayAdapter.createFromResource(            
        	this, R.array.interest_array, android.R.layout.simple_spinner_item);    
        adapter.setDropDownViewResource(
        	android.R.layout.simple_spinner_dropdown_item);    
        spinner.setAdapter(adapter); 
        // ���ǳ� ���: ��  
        
        //// Date Picker: ����  ////////////
        // capture our View elements        
        mDateDisplay = (TextView) findViewById(R.id.edit_birthday);        
        mPickDate = (Button) findViewById(R.id.pickDate);        
        // add a click listener to the button        
        mPickDate.setOnClickListener(new View.OnClickListener() {            
        	public void onClick(View v) {                
        		showDialog(DATE_DIALOG_ID);            
        	}        
        });        
        // get the current date        
        final Calendar c = Calendar.getInstance();        
        mYear = c.get(Calendar.YEAR);        
        mMonth = c.get(Calendar.MONTH);        
        mDay = c.get(Calendar.DAY_OF_MONTH);        
        // display the current date (this method is below)        
        updateDisplay();        
        //// Date Picker: ��  ////////////
        
        ///// ��ư Ŭ�� ���: ����
        // ID�� button_send(main.xml)�� ��ư�� �ʱ�ȭ 
        Button btn = (Button)findViewById(R.id.button_send);
        // ��ư Ŭ�� ���(Ŭ�� �� onClick() �޼ҵ尡 ȣ���) 
        btn.setOnClickListener(this);
        ///// ��ư Ŭ�� ��� ���: ��
    }
	     
    // updates the date in the TextView    
    private void updateDisplay() {        
    	mDateDisplay.setText(            
    			new StringBuilder()                    
    			// Month is 0 based so add 1   
    			.append(mYear).append("-")
    			.append(mMonth + 1).append("-")                    
    			.append(mDay).append(" "));
    }   
    
    // the callback received when the user "sets" the date in the dialog    
    private DatePickerDialog.OnDateSetListener mDateSetListener =            
    		new DatePickerDialog.OnDateSetListener() {                
    	public void onDateSet(DatePicker view, int year,
    			int monthOfYear, int dayOfMonth) {                    
    		mYear = year;                    
    		mMonth = monthOfYear;                    
    		mDay = dayOfMonth;                    
    		updateDisplay();                
    		}            
    	};    
    
    @Override
    protected Dialog onCreateDialog(int id) {    
    	switch (id) {    
	    	case DATE_DIALOG_ID:        
	    		return new DatePickerDialog(this,                    
	    				mDateSetListener,                    
	    				mYear, mMonth, mDay);    
    	}    
    	return null;
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
        String spn_interest = spinner.getSelectedItem().toString();
        
        // ���� ����
        EditText et_birthday = (EditText)findViewById(R.id.edit_birthday);
        String str_birthday = et_birthday.getText().toString();
        
        // �˸�â ��� 
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("�˸�â");
        alert.setMessage("����: " + str_name + "\n����: " + str_sex + "\n���ſ���: " + str_sms + "\n���ɺо�: " + spn_interest + "\n����: " + str_birthday);
        alert.setIcon(R.drawable.ic_launcher);
        alert.setPositiveButton("Ȯ��", null);
        alert.show();
        ///// ���� ��ư Ŭ�� ��, ����ڰ� �Է��� ������ �˸�â�� ���: �� 
    }    
}