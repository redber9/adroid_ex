package com.andro;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoAdvLabActivity extends Activity implements OnClickListener {
	// ���� ��� �迭 ����
	TextView[] tv = new TextView[5];
	// ���� ���� �迭 �ʱ�ȭ
	String[] title = {"����ö1", "�ڵ���2", "����ö3", "�ڵ���4", "����ö5"};
	// main.xml�� ���� ���� ������ ���̾ƿ��� ���� ��ü ����
	LinearLayout layout_videoview;
	// ������ ��ü ����;
	VideoView videoView;
	// ���� ���ҽ� �迭 ����
	Uri[] uri = new Uri[5];
	// ���� ���ҽ��� ���Ͽ� ���� �迭   
	int[] raw_uri	= {R.drawable.subway, 
	    		       R.drawable.street,
	    		       R.drawable.subway,
	    		       R.drawable.street,
	    		       R.drawable.subway};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // main.xml�� ���Ͼ�̾ƿ� �ν� 
        LinearLayout layout_videolist = (LinearLayout)findViewById(R.id.videolist_area);
        // main.xml�� ���Ͼ�̾ƿ� �ν� 
        layout_videoview = (LinearLayout)findViewById(R.id.videoview_area);
        
        ///// ����� ��� ���
        for(int i=0; i<tv.length; i++) {
	        // �ؽ�Ʈ�� ���� 
	        tv[i] = new TextView(this);
	        // �ؽ�Ʈ�信 id �ο�
	        tv[i].setId(i);
	        // �ؽ�Ʈ�信 ���� ��� 
            tv[i].append(title[i]);
	        	
	        // �ؽ�Ʈ��1�� ���� ũ�� ���� 
	        tv[i].setTextSize(25);
	        // �ؽ�Ʈ���� ���ڻ� ����
	        tv[i].setTextColor(Color.YELLOW);
	        // �ؽ�Ʈ�信 Ŭ�� ��� 
	        tv[i].setOnClickListener(this);        
	        // �ؽ�Ʈ���� ���Ͼ�̾ƿ��� �߰� 
	        layout_videolist.addView(tv[i]);
	        
	        // ���� ���ҽ� �ν�
            uri[i] = Uri.parse("android.resource://com.andro/" + raw_uri[i]);
        }
        
        // VideoView�� ��ü ����
        videoView = new VideoView(this);
        // VideoView ��ü�� LinearLayout�� �߰� 
        layout_videoview.addView(videoView);
        
        // �̵�� ����� �ʱ�ȭ
        MediaController mediaController = new MediaController(this);
        
        // �����信 �̵�� ����� ��ġ 
        videoView.setMediaController(mediaController);
    }
 
    public void onClick(View v) {
   
		// Ŭ���� �ؽ�Ʈ���� id �ν�
		int tvId = v.getId();
		
		for(int i=0; i<tv.length; i++) { 
			
			if (i == tvId) {
		        // �ؽ�Ʈ���� ���ڻ� ����
		        tv[i].setTextColor(Color.BLUE);
		        // �ؽ�Ʈ���� ���ڻ� ����
		        tv[i].setBackgroundColor(Color.YELLOW);
			} else {
		        // �ؽ�Ʈ���� ���ڻ� ����
		        tv[i].setTextColor(Color.YELLOW);
		        // �ؽ�Ʈ���� ���ڻ� ����
		        tv[i].setBackgroundColor(Color.BLUE);
			}
		}
        
        // �����信 ���� ���ҽ� ����
        videoView.setVideoURI(uri[tvId]);
        
        // ���� ��� ���� 
        videoView.start();
    }    
}