package com.andro;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AudioAdvLabActivity extends Activity implements OnClickListener {
	// �̵�� �÷��̾� �迭 ����
	MediaPlayer[] mp = new MediaPlayer[2];
	// �ؽ�Ʈ�� �迭 ����
	TextView[]    tv = new TextView[2];
 
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ///// �̵�� �÷��̾� �ʱ�ȭ
        for(int i=0; i<tv.length; i++) {
            // drawable ������ �ִ� ����� ������ ����
        	if (i == 0)
    	        mp[i] = MediaPlayer.create(this, R.drawable.bibidibabidibuu);
        	else if (i == 1)
    	        mp[i] = MediaPlayer.create(this, R.drawable.lovemetender);
            // ����� ������ ���� �� �ݺ� ���� ����(�̹ݺ�)
            mp[0].setLooping(false); 
        }
        
        // main.xml�� ���Ͼ�̾ƿ� �ν� 
        LinearLayout layout = (LinearLayout)findViewById(R.id.album);
        
        ///// ����� ��� ���
        for(int i=0; i<tv.length; i++) {
	        // �ؽ�Ʈ�� ���� 
	        tv[i] = new TextView(this);
	        // �ؽ�Ʈ�信 id �ο�
	        tv[i].setId(i);
	        // �ؽ�Ʈ�信 ���� ��� 
	        if (i == 0)
	            tv[i].append("Bibidi Babidi Buu");
	        else if (i == 1)
	            tv[i].append("Love Me Tender");
	        	
	        // �ؽ�Ʈ��1�� ���� ũ�� ���� 
	        tv[i].setTextSize(20);
	        // �ؽ�Ʈ���� ���ڻ� ����
	        tv[i].setTextColor(Color.YELLOW);
	        // �ؽ�Ʈ�信 Ŭ�� ��� 
	        tv[i].setOnClickListener(this);        
	        // �ؽ�Ʈ���� ���Ͼ�̾ƿ��� �߰� 
	        layout.addView(tv[i]);
        }
    }
    
	// �ؽ�Ʈ�䰡 Ŭ���Ǹ� ����
	public void onClick(View v) {
		// Ŭ���� �ؽ�Ʈ���� id �ν�
		int tvId = v.getId();
		
		// ����� ��� Ŭ�����ο� ���� ��� �� ���/���� ����  
		for (int i=0; i<tv.length; i++) {
	    	// i��° �ؽ�Ʈ�䰡 Ŭ���Ǿ��� ��
	        if(i == tvId) {
	            // ������� ���� ���̸� ����
	            if(mp[i].isPlaying()) {
	                mp[i].pause();
	                tv[i].setTextColor(Color.YELLOW);
	                tv[i].setBackgroundColor(Color.BLACK);
		        // ������� ������ �����̸� ����
	            } else {
	                mp[i].start();
	                tv[i].setTextColor(Color.BLACK);
	         	    tv[i].setBackgroundColor(Color.YELLOW);
	            }
		    // i��° �ؽ�Ʈ�䰡 Ŭ������ ���� ���
	        } else {
	            // ������� ���� ���̸� ����
	        	if(mp[i].isPlaying()) {
	        		mp[i].pause();
	                tv[i].setTextColor(Color.YELLOW);
	                tv[i].setBackgroundColor(Color.BLACK);
	        	} 
	        }  
		} 
    }
}