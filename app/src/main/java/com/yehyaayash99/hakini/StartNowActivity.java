package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class StartNowActivity extends AppCompatActivity {

    TextView haveAccountTV, detailsInActicityTV;
    Button startNowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_now);

        haveAccountTV = findViewById(R.id.haveAccountTV);
        detailsInActicityTV = findViewById(R.id.detailsInActicityTV);
        startNowBtn = findViewById(R.id.startNowBtn);
        startNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartNowActivity.this, SplachActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        String haveAccountText = "لديك بالفعل حساب؟ " + "<b>" + "تسجيل الدخول" + "<b>";
        haveAccountTV.setText(Html.fromHtml(haveAccountText));
        haveAccountTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartNowActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        String detailsInActicityText = "إذا كنت في حالة تقتضي المساعدة الفورية وهناك خطورة على حياتك، " + "<b>" + "يرجى الاتصال مباشرة برقم الطوارئ الخاص بمنطقتك!" + "<b>";
        detailsInActicityTV.setText(Html.fromHtml(detailsInActicityText));
    }
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}