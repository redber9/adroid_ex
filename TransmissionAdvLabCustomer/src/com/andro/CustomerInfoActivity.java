package com.andro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CustomerInfoActivity extends Activity implements OnClickListener {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        // ��Ƽ��Ƽ ���� 
        super.onCreate(savedInstanceState);

        // receive.xml�� ���̾ƿ� ���
        setContentView(R.layout.receive);
        
        // ������ ������ ����Ʈ�� ���� 
        Intent it    = getIntent();

        ///// ����Ʈ�κ��� ��������: ����  
        String str_name = it.getStringExtra("it_name");
        String str_sex = it.getStringExtra("it_sex");
        String str_sms  = it.getStringExtra("it_sms");
        String str_interest  = it.getStringExtra("it_interest");
        String str_birthday  = it.getStringExtra("it_birthday");
        ///// ����Ʈ�κ��� ��������: ��  

        ///// �������� ���: ����
        // ���� ��� 
        TextView tv_name = (TextView)findViewById(R.id.tv_name);
        tv_name.setText(str_name);

        // ���� ���
        TextView tv_sex = (TextView)findViewById(R.id.tv_sex);
        tv_sex.setText(str_sex);

        // SMS ���ſ��� 
        TextView tv_receive = (TextView)findViewById(R.id.tv_receive);
        tv_receive.setText(str_sms);
        
        // ���ɺо� 
        TextView tv_interest = (TextView)findViewById(R.id.tv_interest);
        tv_interest.setText(str_interest);

        // ����
        TextView tv_birthday = (TextView)findViewById(R.id.tv_birthday);
        tv_birthday.setText(str_birthday);        
        ///// �������� ���: ��
        
        // "����" ��ư Ŭ�� ���  
        Button btn = (Button)findViewById(R.id.button_prev);
        btn.setOnClickListener(this);
    }
	
	public void onClick(View v) {
		// ȣ�� ��Ƽ��Ƽ ���� 
		Intent it    = new Intent(this, CustomerRegFormActivity.class);

		// ȣ���� ��Ƽ��Ƽ�� ���� 
		startActivity(it);

		// ���� ��Ƽ��Ƽ ���� 
		finish();
    }
}