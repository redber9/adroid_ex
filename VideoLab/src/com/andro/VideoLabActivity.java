package com.andro;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoLabActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ///// �ؽ�Ʈ�� Ŭ�� ���: ���� 
        // main.xml�� ���̾ƿ��� ��ü�� �ؽ�Ʈ�� �ν�
        TextView tv = (TextView) this.findViewById(R.id.video_album1);
        // �ؽ�Ʈ�信 ������ �߰�(Ŭ�� ���)  
        tv.setOnClickListener(this);
        ///// �ؽ�Ʈ�� Ŭ�� ���: �� 
    }
    
    public void onClick(View v) {
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