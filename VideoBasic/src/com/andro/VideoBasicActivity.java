package com.andro;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoBasicActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ///// main.xml ���̾ƿ��� �ִ� ������ �ν�
        VideoView videoView = (VideoView) findViewById(R.id.videoview_area);
        
        // �̵�� ����� �ʱ�ȭ
        MediaController mediaController = new MediaController(this);
        
        // �����信 �̵�� ����� ��ġ 
        videoView.setMediaController(mediaController);

        // drawable ������ �ִ� ���� ���ҽ�(subway.3gp) �ν�
        Uri raw_uri = Uri.parse("android.resource://com.andro/" + R.drawable.subway);
        
        // �����信 ���ҽ� ����
        videoView.setVideoURI(raw_uri);
        
        // ���� ��� ���� 
        videoView.start();        
    }
}