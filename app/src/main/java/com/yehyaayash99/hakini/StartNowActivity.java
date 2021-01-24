package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class StartNowActivity extends AppCompatActivity {

    TextView haveAccountTV, detailsInActicityTV;
    Button startNowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_now);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        haveAccountTV = findViewById(R.id.haveAccountTV);
        detailsInActicityTV = findViewById(R.id.detailsInActicityTV);
        startNowBtn = findViewById(R.id.startNowBtn);
        startNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        String haveAccountText = "لديك بالفعل حساب؟ " + "<b>" + "تسجيل الدخول" + "<b>";
        haveAccountTV.setText(Html.fromHtml(haveAccountText));


        String detailsInActicityText = "إذا كنت في حالة تقتضي المساعدة الفورية وهناك خطورة على حياتك، " + "<b>" + "يرجى الاتصال مباشرة برقم الطوارئ الخاص بمنطقتك!" + "<b>";
        detailsInActicityTV.setText(Html.fromHtml(detailsInActicityText));
    }
}