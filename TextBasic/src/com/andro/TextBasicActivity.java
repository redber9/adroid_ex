// TextViewActivity Ŭ������ ���ǵǾ� �ִ� ��Ű��
package com.andro;

//Activity Ŭ������ ���ǵǾ� �ִ� ��Ű��
import android.app.Activity;
//Bundle Ŭ������ ���ǵǾ� �ִ� ��Ű��
import android.os.Bundle;

//TextBasicActivity�� Activity Ŭ������ ���� Ŭ������
public class TextBasicActivity extends Activity {
    /** Called when the activity is first created. */
	
	// ���� Ŭ������ Activity Ŭ������ onCreate() �޼ҵ带 �������̵�(������)��
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	// ��Ƽ��Ƽ�� ������(���� Ŭ������ �޼ҵ� �̿�)
        super.onCreate(savedInstanceState);
        // res/layout ������ �ִ� main.xml�� ���̾ƿ��� �����
        setContentView(R.layout.main);
    }
}