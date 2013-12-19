package com.andro;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class AudioLabActivity extends Activity implements OnClickListener {
	MediaPlayer mp;
	TextView    tv; 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // drawable ������ �ִ� bibidibabidibuu.mp3 ���� �ν�
        mp = MediaPlayer.create(this, R.drawable.bibidibabidibuu);
        // ����� ������ ���� �� �ݺ� ���� ����(true: �ݺ�, false: �ݺ� ����)
        mp.setLooping(false); 
        
        ///// main.xml�� TextView ���ҽ��� Ŭ�� ���: ���� 
        // TextView ���ҽ�(ID�� play_music1)�� �ν���
        tv = (TextView) this.findViewById(R.id.play_music1);
        // TextView ���ҽ��� Ŭ�� ���, Ŭ���Ǹ� onClick �޼ҵ尡 �����
        tv.setOnClickListener(this);
        ///// main.xml�� TextView ���ҽ��� Ŭ�� ���: ���� 
    }
    
    // TextView ���ҽ�(ID�� play_music1)�� Ŭ���Ǹ� �����
	public void onClick(View v) {
		///// ����� ����: ����
		// ������� ���� ���� ���
        if(mp.isPlaying()) {
        	// ����� ���� ����
            mp.pause();
            // ���ڻ�: ���
            tv.setTextColor(Color.WHITE);
            // ���� ����: ������ 
            tv.setBackgroundColor(Color.BLACK);
    	// ������� ������ ���� ������ ���
        } else {
        	// ����� ���� 
            mp.start();
            // ���ڻ�: ������
            tv.setTextColor(Color.BLACK);
            // ���ڹ���: �����
            tv.setBackgroundColor(Color.YELLOW);
        }
        ///// ����� ����: ��
    }
}