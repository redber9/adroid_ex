package com.andro;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class EventLabActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ///// ��ư Ŭ�� ���: ����
        // ID�� button_send(main.xml)�� ��ư�� �ʱ�ȭ 
        Button btn = (Button)findViewById(R.id.button_send);
        // ��ư Ŭ�� ���(Ŭ�� �� onClick() �޼ҵ尡 ȣ���) 
        btn.setOnClickListener(this);
        ///// ��ư Ŭ�� ��� ���: ��
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

        // �˸�â ��� 
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("�˸�â");
        alert.setMessage("����: " + str_name + "\n����: " + str_sex + "\n���ſ���: " + str_sms);
        alert.setIcon(R.drawable.ic_launcher);
        alert.setPositiveButton("Ȯ��", null);
        alert.show();
        ///// ���� ��ư Ŭ�� ��, ����ڰ� �Է��� ������ �˸�â�� ���: �� 
    }    
}