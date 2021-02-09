package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yehyaayash99.hakini.Items.LoginResponse;
import com.yehyaayash99.hakini.URLClass.ApiClass;
import com.yehyaayash99.hakini.URLClass.RetrofitClientRegister;
import com.yehyaayash99.hakini.URLClass.UpdateData;
import com.yehyaayash99.hakini.URLClass.UrlClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfessionActivity extends AppCompatActivity {

    EditText professionET;
    Button contineProfessionBtn;

    String token, sex, country, dob, professionText;
    ProgressDialog progressDialog;
    ConstraintLayout professionActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession);

        token = getIntent().getStringExtra("token");
        sex = getIntent().getStringExtra("sex");
        country = getIntent().getStringExtra("country");
        dob = getIntent().getStringExtra("dob");

        professionET = findViewById(R.id.professionET);
        contineProfessionBtn = findViewById(R.id.contineProfessionBtn);
        professionActivity = findViewById(R.id.professionActivity);

        professionActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });

        contineProfessionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                progressDialog = new ProgressDialog(ProfessionActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                professionText = professionET.getText().toString().trim();
                if (!(professionText == null && professionText.isEmpty())) {
                    updateData(token, sex, country, dob, professionText);
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(ProfessionActivity.this, "أدخل مهنتك الحالية", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void updateData(String token, String sex, String country, String dob, String professionText) {
        String t = "Bearer " + token;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(UrlClass.urlUpdateUserDetails)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        ApiClass apiClass = retrofit.create(ApiClass.class);
        Call<UpdateData> call = apiClass.updateData(t, sex, country, dob, professionText);
        call.enqueue(new Callback<UpdateData>() {
            @Override
            public void onResponse(Call<UpdateData> call, Response<UpdateData> response) {
                UpdateData updateData = response.body();

                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    Log.d("ttt", response.toString());

                    Intent intent = new Intent(ProfessionActivity.this, QuestionsActivity.class);
                    startActivity(intent);

                } else {
                    progressDialog.dismiss();
                    Log.d("ttt", response.toString());
                }
            }

            @Override
            public void onFailure(Call<UpdateData> call, Throwable t) {
                progressDialog.dismiss();
                Log.d("ttt", t.getMessage());

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