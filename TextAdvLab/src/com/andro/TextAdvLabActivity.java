package com.andro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;

public class TextAdvLabActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // ��Ƽ��Ƽ �� ���
        setTitle("�����");

        // main.xml�� ���ǵ� LinearLayout �ν�(ID: customers)
        LinearLayout layout = (LinearLayout)findViewById(R.id.customers);
        //  LinearLayout�� ����(���)
        layout.setBackgroundColor(Color.argb(255, 255, 255, 255));
        
        // ����� ��Ÿ������ �����  TextView ��ü ���� 
        TextView tv_name;
        TextView tv_etc;
        
        ///// �� 1�� ����: ���� /////
        // �� 1�� ������ LinearLayout ���� �߰�
        tv_name = new TextView(this); // TextView ��ü ����
        tv_name.append("ȫ�浿"); // ���� ��� 
        tv_name.setTextSize(20); // ���� ũ��
        tv_name.setTextColor(Color.argb(255, 255, 255, 0)); // ���� ��
        tv_name.setBackgroundColor(Color.argb(100, 0, 0, 255)); // ���� ����
        layout.addView(tv_name); // TextView ��ü�� LinearLayout ��ü�� �߰�        
        // �� 1�� ��Ÿ������ LinearLayout ���� �߰�
        tv_etc = new TextView(this);
        tv_etc.append("����\n");
        tv_etc.append("02-555-1234");
        tv_etc.setTextColor(Color.argb(255, 0, 0, 0));
        layout.addView(tv_etc); 
        ///// �� 1�� ����: �� /////
        
        ///// �� 2�� ����: ���� /////
        // �� 2�� ������ LinearLayout ���� �߰�
        tv_name = new TextView(this);
        tv_name.append("��û");
        tv_name.setTextSize(20);
        tv_name.setTextColor(Color.argb(255, 255, 255, 0));
        tv_name.setBackgroundColor(Color.argb(100, 0, 0, 255));
        layout.addView(tv_name);
        // �� 2�� ��Ÿ������ LinearLayout ���� �߰�
        tv_etc = new TextView(this);
        tv_etc.append("������\n");
        tv_etc.append("033-777-1234");
        tv_etc.setTextColor(Color.argb(255, 0, 0, 0));
        layout.addView(tv_etc);           
        ///// �� 2�� ����: �� /////
    }
}