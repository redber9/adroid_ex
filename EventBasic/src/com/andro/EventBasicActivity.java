package com.andro;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EventBasicActivity extends Activity implements OnClickListener {
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
    
        ///// �˸�â�� ���: ���� /////
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("�˸�â");
        alert.setMessage("���� ��ư�� �����̳׿�!");
        alert.setIcon(R.drawable.ic_launcher);
        alert.setPositiveButton("Ȯ��", null);
        alert.show();
    	///// �˸�â�� ���: �� /////
    }    
}