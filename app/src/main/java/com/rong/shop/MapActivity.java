package com.rong.shop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;

/**
 * Created by Administrator on 2017/2/15.
 */
public class MapActivity extends AppCompatActivity implements LocationSource,AMapLocationListener {

    private AMap aMap;
    private MapView mMapView;

    private OnLocationChangedListener mListener;
    public AMapLocationClient mapLocationClient;
    public AMapLocationClientOption mapLocationClientOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        mMapView = (MapView) findViewById(R.id.map);
        //在activity执行onCreate时执行mMapView.onCreate(savedInstanceState)，实现地图生命周期管理
        mMapView.onCreate(savedInstanceState);
        if (aMap == null) {
            aMap = mMapView.getMap();
        }

        aMap.moveCamera(CameraUpdateFactory.zoomTo(17));

        //LatLng latLng =new LatLng(112.53,37.87);
        //aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,17));

        // 设置定位监听
        aMap.setLocationSource(this);
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setMyLocationEnabled(true);
        // 设置定位的类型为定位模式，有定位、跟随或地图根据面向方向旋转几种
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);

        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
    }


    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        if(mapLocationClient!=null){
            mapLocationClient.onDestroy();
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，实现地图生命周期管理
        mMapView.onSaveInstanceState(outState);
    }


    //激活定位
    @Override
    public void activate(OnLocationChangedListener listener) {
        mListener = listener;
        if (mapLocationClient == null) {

            mapLocationClient = new AMapLocationClient(this);
            mapLocationClientOption = new AMapLocationClientOption();

            mapLocationClient.setLocationListener(this);//设置定位回调监听

            mapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//设置为高精度定位模式
            mapLocationClientOption.setNeedAddress(true);//是否返回地址信息
            mapLocationClientOption.setOnceLocation(false);//是否只定位一次
            mapLocationClientOption.setWifiActiveScan(true);//设置是否强制刷新WIFI，默认为强制刷新
            mapLocationClientOption.setMockEnable(false);//是否允许模拟位置
            mapLocationClientOption.setInterval(2000);//定位时间间隔

            mapLocationClient.setLocationOption(mapLocationClientOption);
            mapLocationClient.startLocation();//开启定位
        }
    }

    //停止定位
    @Override
    public void deactivate() {
        mListener = null;
        if (mapLocationClient != null) {
            mapLocationClient.stopLocation();
            mapLocationClient.onDestroy();
        }
        mapLocationClient = null;
    }


    //定位成功后回调函数
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (mListener != null&&aMapLocation != null) {
            if (aMapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(aMapLocation);// 显示系统小蓝点

                /*StringBuilder stringBuilder = new StringBuilder();
                //定位成功回调信息，设置相关消息
                int type = aMapLocation.getLocationType();
                String address = aMapLocation.getAddress();
                stringBuilder.append(type + address);
                Toast.makeText(this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();*/
            } else {
                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见下方错误码表。
                Log.i("error info：", "定位失败"+aMapLocation.getErrorCode() + ":" + aMapLocation.getErrorInfo());
            }
        }
    }
}

