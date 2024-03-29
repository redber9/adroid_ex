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
        
        ///// 리스트뷰 생성: 시작 /////
        // strings.xml에 정의된 국가명 아이템을 문자열 배열로 저장 
        String[] countries = getResources().getStringArray(R.array.countries_array);
        // 문자열 배열의 각 문자열을 main.xml의 TextView로 대응하는 리스트뷰를 위한 커서를 만듦  
        setListAdapter(new ArrayAdapter<String>(this, R.layout.main, countries));
        // 리스트뷰를 생성함 
        ListView lv = getListView();
        ///// 리스트뷰 생성: 끝 /////        
        
        // 리스트뷰의 클릭 대기 
        lv.setOnItemClickListener(this);
    }
    
    // 리스트뷰의 아이템이 클릭되었을 때 실행 
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    	///// 알림창을 띄움: 시작 /////
    	AlertDialog.Builder alert = new AlertDialog.Builder(ListViewActivity.this);
        alert.setTitle("알림창");
        // 클릭된 아이템 위치, 아이템명 출력
        alert.setMessage(position + ", " + ((TextView)view).getText() + "를  누르셨네요!");
        alert.setIcon(R.drawable.ic_launcher);
        alert.setPositiveButton("확인", null);
        alert.show();
    	///// 알림창을 띄움: 끝 /////
    }
}