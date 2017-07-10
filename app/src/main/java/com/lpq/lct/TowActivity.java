package com.lpq.lct;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TowActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CountApplication.getCountConfig().getHandlerTimeCount().onStartTimeCount(this.getClass().getSimpleName());
        CountApplication.getCountConfig().getHandlerEventCount().onEventCount("event1", 2, 2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        CountApplication.getCountConfig().getHandlerTimeCount().onEndTimeCount(this.getClass().getSimpleName());
    }

    @Override
    public void onClick(View v) {
        CountApplication.getCountConfig().getHandlerClickCount().onClickCount("TowActivity.btn");
    }
}
