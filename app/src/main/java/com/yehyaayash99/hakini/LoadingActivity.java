package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

public class LoadingActivity extends AppCompatActivity {

    int activityChoose;
    ConstraintLayout loadingActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        activityChoose = getIntent().getIntExtra("activityChoose", 0);

        loadingActivity = findViewById(R.id.loadingActivity);
        loadingActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });

        Button loadingStartNowBtn = findViewById(R.id.loadingStartNowBtn);
        loadingStartNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (activityChoose) {
                    case 2:
                        Intent intent2 = new Intent(LoadingActivity.this, ChooseTherapistActivity.class);
                        startActivity(intent2);
                        break;

                    default:
                        Intent intent0 = new Intent(LoadingActivity.this, ChatActivity.class);
                        startActivity(intent0);
                        break;
                }

            }
        });
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}