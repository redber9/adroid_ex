package com.andro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;

public class ImageAdvLabActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // main.xml�� �ִ� LinearLayout �ν�
        LinearLayout layout = (LinearLayout)findViewById(R.id.pictures);
        // ���̾ƿ��� ����, ���� ũ�� ����  
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(300, 200);

        // TextView ��ü�� ���� 
        TextView tv_name;
        TextView tv_desc;
        // ImageView ��ü�� ����
        ImageView iv;
        
        ///// �̹���1�� ���� �׸��� ����: ���� ///// 
        // tv_name ��ü �ʱ�ȭ 
        tv_name = new TextView(this);
        // ���� �߰� 
        tv_name.append("��");
        // ���� ũ�� 
        tv_name.setTextSize(20);
        // ���ڻ�
        tv_name.setTextColor(Color.rgb(255, 255, 0));
        // ���� 
        tv_name.setBackgroundColor(Color.rgb(0, 0, 255));
        // tv_name ��ü�� layout ��ü�� �߰� 
        layout.addView(tv_name);
        
        // tv_desc ��ü �ʱ�ȭ 
        tv_desc = new TextView(this);
        // ���� �߰� 
        tv_desc.append("å�� ���� �Ű� ��Ʈ");
        // tv_desc ��ü�� layout ��ü�� �߰� 
        layout.addView(tv_desc);  
        
        // iv ��ü �ʱ�ȭ
        iv = new ImageView(this);
        // �̹��� �ҽ� ����
        iv.setBackgroundResource(R.drawable.img1);
        // �̹��� ũ�� 
        iv.setLayoutParams(params);
        // iv ��ü�� layout ��ü�� �߰�
        layout.addView(iv);
        ///// �̹���1�� ���� �׸��� ����: �� ///// 
        
        ///// �̹���2�� ���� �׸��� ����: ���� ///// 
        // tv_name ��ü �ʱ�ȭ 
        tv_name = new TextView(this);
        // ���� �߰� 
        tv_name.append("����");
        // ���� ũ�� 
        tv_name.setTextSize(20);
        // ���ڻ�
        tv_name.setTextColor(Color.rgb(255, 255, 0));
        // ���� 
        tv_name.setBackgroundColor(Color.rgb(0, 0, 255));
        // tv_name ��ü�� layout ��ü�� �߰� 
        layout.addView(tv_name);
        
        // tv_desc ��ü �ʱ�ȭ 
        tv_desc = new TextView(this);
        // ���� �߰� 
        tv_desc.append("��� ���� Ž���� ����");
        // tv_desc ��ü�� layout ��ü�� �߰� 
        layout.addView(tv_desc);  
        
        // iv ��ü �ʱ�ȭ
        iv = new ImageView(this);
        // �̹��� �ҽ� ����
        iv.setBackgroundResource(R.drawable.img2);
        // �̹��� ũ�� 
        iv.setLayoutParams(params);
        // iv ��ü�� layout ��ü�� �߰�
        layout.addView(iv);
        ///// �̹���2�� ���� �׸��� ����: �� ///// 
    }
}