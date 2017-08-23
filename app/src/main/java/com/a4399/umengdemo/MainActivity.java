package com.a4399.umengdemo;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.a4399.umengdemo.permission.PermissionCallback;
import com.a4399.umengdemo.permission.PermissionManager;

public class MainActivity extends AppCompatActivity {

    private String[] mPermissons = {Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_WIFI_STATE, Manifest.permission.ACCESS_NETWORK_STATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void checkPermissionAndThenLoad() {



        //check for permission
        if (PermissionManager.hasPermission(MainActivity.this,mPermissons)) {
        } else {
            PermissionManager.askForPermission(this, Manifest.permission.READ_PHONE_STATE, permissionReadstorageCallback);
        }
    }



    private final PermissionCallback permissionReadstorageCallback = new PermissionCallback() {
        @Override
        public void permissionGranted() {
        }

        @Override
        public void permissionRefused() {
            finish();
        }
    };

    public void onClick(View v) {
        int id = v.getId();
        Intent in = null;
        if (id == R.id.normal) {
            in = new Intent(this, AnalyticsHome.class);
        } else if (id == R.id.game) {
            //in = new Intent(this, GameAnalyticsHome.class);
        }

        startActivity(in);
    }
    @Override
    public void onRequestPermissionsResult(
            int requestCode, String[] permissions, int[] grantResults) {
        PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
