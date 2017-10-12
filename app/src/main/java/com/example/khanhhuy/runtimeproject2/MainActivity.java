package com.example.khanhhuy.runtimeproject2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int LOCATION = 1;
    private static final int CALL = 2;
    private static final int WRITE_EXST = 3;
    private static final int READ_EXST = 4;
    private static final int CAMERA = 5;
    private static final int ACCOUNTS = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean underSdk() {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M;
    }

    public void selected(View v) {
        switch (v.getId()) {
            case R.id.button_location:
                askForPermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION);
                break;
            case R.id.button_call:
                askForPermission(Manifest.permission.CALL_PHONE, CALL);
                break;
            case R.id.button_write_storage:
                askForPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, WRITE_EXST);
                break;
            case R.id.buton_read_storage:
                askForPermission(Manifest.permission.READ_EXTERNAL_STORAGE, READ_EXST);
                break;
            case R.id.button_camera:
                askForPermission(Manifest.permission.CAMERA, CAMERA);
                break;
            case R.id.button_account:
                askForPermission(Manifest.permission.GET_ACCOUNTS, ACCOUNTS);
                break;
            default:
                break;
        }
    }

    private void askForPermission(String permission, Integer requestCode) {
        if (underSdk()) {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        } else {
            if (ContextCompat.checkSelfPermission(MainActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{permission}, requestCode);
            } else {
                Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 1:
                Log.e("khanhhuy",""+1);
                 break;
            case 2:
                Log.e("khanhhuy",""+2);
                break;
            case 3:
                Log.e("khanhhuy",""+3);
                break;
            case 4:
                Log.e("khanhhuy",""+4);
                break;
            case 5:
                Log.e("khanhhuy",""+5);
                break;
            case 6:
                Log.e("khanhhuy",""+6);
                break;
        }
    }

}
