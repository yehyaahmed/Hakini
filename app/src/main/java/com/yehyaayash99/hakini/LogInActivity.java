package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.yehyaayash99.hakini.Items.LoginResponse;
import com.yehyaayash99.hakini.URLClass.RetrofitClientLogin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {

    TextView noHaveAccountTV;
    TextInputEditText emailLoginEditText, passwordLoginEditText;
    TextInputLayout textInputLayout5, textInputLayout7;
    Button loginBtn;

    public static String token;
    ProgressDialog progressDialog;

    ConstraintLayout logInActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
/*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
*/
        initUI();

        logInActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });

        String noHaveAccountText = "ليس لديك حساب؟ " + "<b>" + "لنبدأ الرحلة معا" + "<b>";
        noHaveAccountTV.setText(Html.fromHtml(noHaveAccountText));
        noHaveAccountTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, Register2Activity.class);
                startActivity(intent);
            }
        });

/*
        emailLoginEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textInputLayout5.setPaddingRelative(20, 8, 20, 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        passwordLoginEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textInputLayout7.setPaddingRelative(20, 8, 20, 0);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
*/

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(LogInActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                userLogin();
            }
        });
    }

    private void initUI() {
        noHaveAccountTV = findViewById(R.id.noHaveAccountTV);
        textInputLayout5 = findViewById(R.id.textInputLayout5);
        textInputLayout7 = findViewById(R.id.textInputLayout7);
        emailLoginEditText = findViewById(R.id.emailLoginEditText);
        passwordLoginEditText = findViewById(R.id.passwordLoginEditText);
        loginBtn = findViewById(R.id.loginBtn);
        logInActivity = findViewById(R.id.constraintLayout2);
    }

    private void userLogin() {

        String email = emailLoginEditText.getText().toString().trim();
        String password = passwordLoginEditText.getText().toString().trim();

        Call<LoginResponse> call = RetrofitClientLogin
                .getInstanceLogin()
                .getApi()
                .userLogin(email, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse body = response.body();
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    Log.d("ttt", body.getMsg() + "");
                    token = body.getData().getApi_token();
                    Intent intent = new Intent(LogInActivity.this, DetailsUserActivity.class);
                    intent.putExtra("token", body.getData().getApi_token());
                    startActivity(intent);
                } else {
                    progressDialog.dismiss();
                    Log.d("ttt", response.message() + "");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.d("ttt", t.getMessage());
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}