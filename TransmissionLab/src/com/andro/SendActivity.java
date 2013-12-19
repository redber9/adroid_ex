package com.andro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.CheckBox;
import android.view.View.OnClickListener;
import android.content.Intent;

public class SendActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ///// ��ư Ŭ�� ���: ����
        // ��ư ID �ν�
        Button btn = (Button)findViewById(R.id.button_send);
        // ��ư Ŭ�� ��� 
        btn.setOnClickListener(this);
        ///// ��ư Ŭ�� ���: �� 
    }
        
    public void onClick(View v) {
        ///// �Է� ���� ����: ���� 
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
        CheckBox   chk_sms = (CheckBox)findViewById(R.id.checkbox_sms);
        String str_sms = "";
        if (chk_sms.isChecked()) {
        	str_sms = (String)chk_sms.getText();	
        }
        ///// �Է� ���� ����: �� 

        // ȣ���� Ŭ���� ���� 
        Intent it    = new Intent(this, ReceiveActivity.class);
    
        ///// ������ ������ ����Ʈ�� ����: ����
        it.putExtra("it_name", str_name);
        it.putExtra("it_sex", str_sex);
        it.putExtra("it_sms",  str_sms);
        ///// ������ ������ ����Ʈ�� ����: ��
  
        // ȣ���� Ŭ������ �׺�Ƽ��� ���� 
        startActivity(it);

        // ���� ��Ƽ��Ƽ ����
        finish();
    }
}