package com.example.logcheck;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    protected void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle","onCreate Invoked");
    }
    protected void onStart()
    {
        super.onStart();
        Log.d("LifeCycle","onStart Invoked");
    }
    protected void onResume()
    {
        super.onResume();
        Log.d("LifeCycle","onResume Invoked");
    }
    protected void onPause()
    {
        super.onPause();
        Log.d("LifeCycle","onPouse Invoked");
    }
    protected void onStop()
    {
        super.onStop();
        Log.d("LifeCycle","onStop Invoked");
    }
    protected void onRestart()
    {
        super.onRestart();
        Log.d("LifeCycle","onRestart Invoked");
    }
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("LifeCycle","onDestroy Invoked");
    }
}