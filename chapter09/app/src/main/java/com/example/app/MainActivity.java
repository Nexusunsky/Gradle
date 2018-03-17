package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text2 = findViewById(R.id.show_text2);
        TextView text3 = findViewById(R.id.show_text3);
        String[] libraryNames = getPackageManager().getSystemSharedLibraryNames();
        for (String libraryName : libraryNames) {
            Log.d(TAG, "libraryNames:" + libraryName);
        }
        text2.setText(BuildConfig.WEB_URL);
        text3.setText(R.string.channel_tips);
    }
}
