package com.andro;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.app.AlertDialog;

public class ListViewActivity extends ListActivity implements OnItemClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        ///// ����Ʈ�� ����: ���� /////
        // strings.xml�� ���ǵ� ������ �������� ���ڿ� �迭�� ���� 
        String[] countries = getResources().getStringArray(R.array.countries_array);
        // ���ڿ� �迭�� �� ���ڿ��� main.xml�� TextView�� �����ϴ� ����Ʈ�並 ���� Ŀ���� ����  
        setListAdapter(new ArrayAdapter<String>(this, R.layout.main, countries));
        // ����Ʈ�並 ������ 
        ListView lv = getListView();
        ///// ����Ʈ�� ����: �� /////        
        
        // ����Ʈ���� Ŭ�� ��� 
        lv.setOnItemClickListener(this);
    }
    
    // ����Ʈ���� �������� Ŭ���Ǿ��� �� ���� 
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    	///// �˸�â�� ���: ���� /////
    	AlertDialog.Builder alert = new AlertDialog.Builder(ListViewActivity.this);
        alert.setTitle("�˸�â");
        // Ŭ���� ������ ��ġ, �����۸� ���
        alert.setMessage(position + ", " + ((TextView)view).getText() + "��  �����̳׿�!");
        alert.setIcon(R.drawable.ic_launcher);
        alert.setPositiveButton("Ȯ��", null);
        alert.show();
    	///// �˸�â�� ���: �� /////
    }
}