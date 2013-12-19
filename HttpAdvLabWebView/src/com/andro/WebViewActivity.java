package com.andro;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // main.xml�� ���̾ƿ��� �ִ� WebView �ν�
        WebView mWebView = (WebView) findViewById(R.id.webview); 
        // WebView�� �ڹٽ�ũ��Ʈ�� �����ϵ��� ������
        mWebView.getSettings().setJavaScriptEnabled(true);  
        // ���信 ������ URL�� ������ ��� 
        mWebView.loadUrl("http://www.google.com");        
    }
}