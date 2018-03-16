package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] libraryNames = getPackageManager().getSystemSharedLibraryNames();
        for (String libraryName : libraryNames) {
            Log.d(TAG, "libraryNames:" + libraryName);
        }
        Toast.makeText(MainActivity.this, BuildConfig.WEB_URL, Toast.LENGTH_SHORT).show();
    }
}
