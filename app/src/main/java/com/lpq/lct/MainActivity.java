package com.lpq.lct;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
        CountApplication.getCountConfig().getHandlerEventCount().onEventCount("event1", 2, 1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CountApplication.getCountConfig().getHandlerTimeCount().onStartTimeCount(this.getClass().getSimpleName());

    }

    @Override
    protected void onPause() {
        super.onPause();
        CountApplication.getCountConfig().getHandlerTimeCount().onEndTimeCount(this.getClass().getSimpleName());
    }

    @Override
    public void onClick(View v) {
        CountApplication.getCountConfig().getHandlerClickCount().onClickCount("MainActivity.btn");
        startActivity(new Intent(this, TowActivity.class));
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ((CountApplication) getApplication()).exitApp(this);
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
