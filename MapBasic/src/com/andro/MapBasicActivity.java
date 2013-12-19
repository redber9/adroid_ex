package com.andro;

import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MapBasicActivity extends MapActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // mani.xml�� MapView Ŭ������ �̿��� �������   
        MapView mapView = (MapView) findViewById(R.id.mapview);

        // ������ �� ��Ʈ�ѷ� �߰� 
        mapView.setBuiltInZoomControls(true);
        
        // ���� ������ ��ġ(����, �浵)
        GeoPoint geopt = new GeoPoint((int)(37.565467*1E6), (int)(126.975431*1E6));
        
        // ��ġ ������ ���� ��Ʈ�ѷ� ����
        MapController mapCtrl = mapView.getController();
        // ������ Ȯ��(1~21)
        mapCtrl.setZoom(16);
        // ������ ��ġ�� ���� �߽� ����
        mapCtrl.setCenter(geopt);
    }
    
    // MapActivity Ŭ������ �߻�ȭ �޼ҵ��μ� override �Ǿ�� ��
	@Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}