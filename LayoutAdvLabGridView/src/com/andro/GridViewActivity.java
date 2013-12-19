package com.andro;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class GridViewActivity extends Activity implements OnItemClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // main.xml�� ���̾ƿ��� �ִ� GridView�� �ν��� 
        GridView gridview = (GridView) findViewById(R.id.gridview);
        // GridView�� �̹������� ��ġ��  
        gridview.setAdapter(new ImageAdapter(this));    
        // GridView�� ��Ÿ���� �����ۿ� ���� Ŭ�� ���, Ŭ���Ǹ� onItemClick() �޼ҵ带 ������  
        gridview.setOnItemClickListener(this);
    }
    
	// @Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    	///// �˸�â�� ���: ���� /////
    	AlertDialog.Builder alert = new AlertDialog.Builder(GridViewActivity.this);
        alert.setTitle("�˸�â");
        // Ŭ���� �̹��� ��ġ ���
        alert.setMessage(position + "��° �̹����� �����̳׿�!");
        alert.setIcon(R.drawable.ic_launcher);
        alert.setPositiveButton("Ȯ��", null);
        alert.show();
    	///// �˸�â�� ���: �� /////
	}
}