package com.andro;

import java.util.List;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;

public class MapAdvLabActivity extends MapActivity implements LocationListener {
	MapView         mapView;
	MapController   mapCtrl; 
	LocationManager lm;	
	MyLocationOverlay myLocationOverlay;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // main.xml�� MapView Ŭ������ �̿��� �������
        mapView = (MapView) findViewById(R.id.mapview);
        // �� ��Ʈ�ѷ� �߰�
        mapView.setBuiltInZoomControls(true);
        
        // ��ġ ������ ���� ��Ʈ�ѷ� ����
        mapCtrl = mapView.getController();
        // ������ Ȯ��
        mapCtrl.setZoom(16);

        ///// ���� ��ġ�� ������ ǥ����: ����  
        // ���� ��ġ�� MapView�� ����ϱ� ���� MyLocationOverlay Ŭ������ ��ü ���� 
        myLocationOverlay = new MyLocationOverlay(this, mapView);
        // �ʺ�κ��� ������� overlay ����Ʈ�� List Ŭ������ ��ü�� �Ҵ�  
        List<Overlay>overlays = mapView.getOverlays();
        // overlay�� ���� ��ġ�� �߰���  
        overlays.add(myLocationOverlay);
        ///// ���� ��ġ�� ������ ǥ����: ��
    }

    // ���� ��ġ�� ���� �浵 (��ġ�� ���ϸ� �ڵ� ������)
    public void onLocationChanged(Location location) {
        GeoPoint geopt = new GeoPoint(
        		(int)(location.getLatitude()*1E6),
        		(int)(location.getLongitude()*1E6));
        
        mapCtrl.setCenter(geopt);
    }
    
    // MapActivity Ŭ������ �߻�ȭ �޼ҵ��μ� override �Ǿ�� ��
	@Override
    protected boolean isRouteDisplayed() {
        return false;
    }
	
	// ��Ƽ��Ƽ�� ������ �� �����
    @Override
    public void onStart() {
        super.onStart();
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
    }

    // ��Ƽ��Ƽ�� ȭ���� ����ο� ���� �� �����
    public void onResume() {
    	super.onResume();
    	// ���� ��ġ ǥ��
    	myLocationOverlay.enableMyLocation();
    	// ��ħ�� ǥ��
    	myLocationOverlay.enableCompass();
    }
    
    // ��Ƽ��Ƽ�� �������� ȭ���� ����ο� ���� ���� �� �����
    public void onPause() {
    	super.onPause();
    	// ���� ��ġ ǥ�� ����  
    	myLocationOverlay.disableMyLocation();
    	// ��ħ�� ǥ�� ���� 
    	myLocationOverlay.disableCompass();
    }
    
    // ��Ƽ��Ƽ�� ������ �ʰ� �� �� �����
    public void onStop() {
    	super.onStop();
    	lm.removeUpdates(this);
    }
    
    // LocationListener Ŭ������ �߻�ȭ �޼ҵ��μ� override �Ǿ�� ��
    public void onProviderEnabled(String provider) {
    }
    
    // LocationListener Ŭ������ �߻�ȭ �޼ҵ��μ� override �Ǿ�� ��
    public void onProviderDisabled(String provider) {
    }
    
    // LocationListener Ŭ������ �߻�ȭ �޼ҵ��μ� override �Ǿ�� ��
    public void onStatusChanged(String provider, int status, Bundle bd) {
    }
}