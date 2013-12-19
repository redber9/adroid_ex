package com.andro;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerActivity extends Activity {
	private TextView mDateDisplay;    
	private int mYear;    
	private int mMonth;    
	private int mDay;    
	static final int DATE_DIALOG_ID = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

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
}