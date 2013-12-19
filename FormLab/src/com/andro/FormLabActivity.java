package com.andro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FormLabActivity extends Activity {
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
        Spinner spinner = (Spinner) findViewById(R.id.spinner_interest);
        // (4) ���ǳʿ� ArrayAdapter�� ������ 
        spinner.setAdapter(adapter);        
        ///// ���ǳ� ���: �� 
    }
}