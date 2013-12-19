package com.andro;

import android.app.Activity;
import android.os.Bundle;
import android.media.MediaPlayer;

public class AudioBasicActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // drawable ������ �ִ� bibidibabidibuu.mp3 ���� �ν�
        MediaPlayer mp = MediaPlayer.create(this,R.drawable.bibidibabidibuu);
        // ����� ������ ���� �� �ݺ� ���� ����(true: �ݺ�, false: �ݺ� ����)
        mp.setLooping(false); 
        // ����� ���� 
        mp.start();
    }
}