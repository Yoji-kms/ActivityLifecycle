package com.yoji.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView lifecycleTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        appendMethodToTextViewAndLog("onCreate");
        appendMethodToTextViewAndLog("Bundle is null: " + (savedInstanceState == null));
    }

    private void initView(){
        lifecycleTxtView = findViewById(R.id.lifecycleTxtViewId);
    }

    private void appendMethodToTextViewAndLog (String methodName){
        lifecycleTxtView.append("\n" + methodName);
        Log.d("Lifecycle", methodName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        appendMethodToTextViewAndLog("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        appendMethodToTextViewAndLog("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        appendMethodToTextViewAndLog("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        appendMethodToTextViewAndLog("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appendMethodToTextViewAndLog("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        appendMethodToTextViewAndLog("onRestart");
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        appendMethodToTextViewAndLog("onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        appendMethodToTextViewAndLog("onPostResume");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        appendMethodToTextViewAndLog("onKeyDown");
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        appendMethodToTextViewAndLog("onKeyLongPress");
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        appendMethodToTextViewAndLog("onBackPressed");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("lifecycle", lifecycleTxtView.getText().toString());
        appendMethodToTextViewAndLog("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lifecycleTxtView.setText(savedInstanceState.getString("lifecycle"));
        appendMethodToTextViewAndLog("onRestoreInstanceState");
    }
}