package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.yehyaayash99.hakini.Items.UpdateData2;
import com.yehyaayash99.hakini.URLClass.ApiClass;
import com.yehyaayash99.hakini.URLClass.UpdateData;
import com.yehyaayash99.hakini.URLClass.UrlClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubScriptinPlanActivity extends AppCompatActivity {

    ImageView subScriptionChoose1IV, subScriptionChoose2IV,
            subScriptionSelected1IV, subScriptionSelected2IV;

    Button subScriptionContinueBtn;

    int n = 0;
    String result;

    ProgressDialog progressDialog;

    int activityChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_scriptin_plan);
        init();
        checkSelect();

        subScriptionChoose1IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = 1;
                checkSelect();
            }
        });

        subScriptionChoose2IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = 2;
                checkSelect();
            }
        });

        subScriptionContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(SubScriptinPlanActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                if (result != null) {
                    if (LogInActivity.token != null) {
                        uploadSubScription(LogInActivity.token);
                    } else {
                        uploadSubScription(Register2Activity.token);
                    }
                } else {
                    Toast.makeText(SubScriptinPlanActivity.this, "اختر نوع الإشتراك", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        subScriptionContinueBtn = findViewById(R.id.subScriptionContinueBtn);

        subScriptionChoose1IV = findViewById(R.id.subScriptionChoose1IV);
        subScriptionChoose2IV = findViewById(R.id.subScriptionChoose2IV);
        subScriptionSelected1IV = findViewById(R.id.subScriptionSelected1IV);
        subScriptionSelected2IV = findViewById(R.id.subScriptionSelected2IV);

    }

    private void checkSelect() {
        switch (n) {
            case 1:
                subScriptionSelected1IV.setVisibility(View.VISIBLE);
                subScriptionSelected2IV.setVisibility(View.GONE);
                result = "اشتراك عادي";
                activityChoose = 1;
                break;
            case 2:
                subScriptionSelected1IV.setVisibility(View.GONE);
                subScriptionSelected2IV.setVisibility(View.VISIBLE);
                result = "اشتراك ذهبي";
                activityChoose = 2;
                break;

            default:
                subScriptionSelected1IV.setVisibility(View.GONE);
                subScriptionSelected2IV.setVisibility(View.GONE);
                activityChoose = 1;
                break;
        }
    }

    private void uploadSubScription(String token) {
        String t = "Bearer " + token;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(UrlClass.urlUpdateUserDetails)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        ApiClass apiClass = retrofit.create(ApiClass.class);
        Call<UpdateData2> call = apiClass.uploadSubScription(t, result);
        call.enqueue(new Callback<UpdateData2>() {
            @Override
            public void onResponse(Call<UpdateData2> call, Response<UpdateData2> response) {
                UpdateData2 body = response.body();

                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    Log.d("ttt", response.toString());

                    Intent intent = new Intent(SubScriptinPlanActivity.this, LoadingActivity.class);
                    intent.putExtra("activityChoose", activityChoose);
                    startActivity(intent);
                } else {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<UpdateData2> call, Throwable t) {
                progressDialog.dismiss();
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