package com.andro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReceiveActivity extends Activity implements OnClickListener {
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
        ///// ����Ʈ�κ��� ��������: ��  

        ///// �������� ���: ����
        ///// ���� ��� 
        TextView tv_name = (TextView)findViewById(R.id.tv_name);
        tv_name.setText(str_name);

        ///// ���� ���
        TextView tv_sex = (TextView)findViewById(R.id.tv_sex);
        tv_sex.setText(str_sex);

        ///// SMS ���ſ��� ���
        TextView tv_receive = (TextView)findViewById(R.id.tv_receive);
        tv_receive.setText(str_sms);
        ///// �������� ���: ��
        
        // "����" ��ư Ŭ�� ���  
        Button btn = (Button)findViewById(R.id.button_prev);
        btn.setOnClickListener(this);
    }
	
	public void onClick(View v) {
		// ȣ�� ��Ƽ��Ƽ ���� 
		Intent it    = new Intent(this, SendActivity.class);

		// ȣ���� ��Ƽ��Ƽ�� ���� 
		startActivity(it);

		// ���� ��Ƽ��Ƽ ���� 
		finish();
    }
}