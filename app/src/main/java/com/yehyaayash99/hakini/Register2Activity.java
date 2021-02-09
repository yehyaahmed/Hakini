package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.yehyaayash99.hakini.Items.DataLogin;
import com.yehyaayash99.hakini.Items.LoginResponse;
import com.yehyaayash99.hakini.URLClass.RetrofitClientRegister;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register2Activity extends AppCompatActivity {

    TextInputLayout textInputLayout4, textInputLayout2, textInputLayout;
    TextInputEditText usernameEditText, emailEditText, passwordEditText;
    TextView haveAccountRegisterTV;
    Button registerBtn;

    public static String token;
    ProgressDialog progressDialog;

    ConstraintLayout register2Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

/*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

 */

        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        textInputLayout = findViewById(R.id.textInputLayout);
        textInputLayout2 = findViewById(R.id.textInputLayout2);
        textInputLayout4 = findViewById(R.id.textInputLayout4);
        haveAccountRegisterTV = findViewById(R.id.haveAccountRegisterTV);
        registerBtn = findViewById(R.id.register2Btn);
        register2Activity = findViewById(R.id.register2Activity);
        register2Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });
/*
        usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textInputLayout4.setPaddingRelative(20, 8, 20, 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textInputLayout2.setPaddingRelative(20, 8, 20, 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textInputLayout.setPaddingRelative(20, 8, 20, 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
*/
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(Register2Activity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                userRegister();

            }
        });

        haveAccountRegisterTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register2Activity.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        String haveAccountRegisterText = "لديك بالفعل حساب؟ " + "<b>" + "تسجيل الدخول" + "<b>";
        haveAccountRegisterTV.setText(Html.fromHtml(haveAccountRegisterText));


    }

    private void userRegister() {

        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();

        Call<LoginResponse> call = RetrofitClientRegister
                .getInstanceRegister()
                .getApi()
                .userRegister(email, password, username);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse body = response.body();
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    DataLogin data = body.getData();
                    Log.d("ttt", response.toString() + "");
                    Log.d("ttt", data.getApi_token() + "");
                    token = body.getData().getApi_token();
                    Intent intent = new Intent(Register2Activity.this, DetailsUserActivity.class);
                    intent.putExtra("token", data.getApi_token());
                    startActivity(intent);

                } else {
                    progressDialog.dismiss();
                    Log.d("ttt", response.toString() + "");

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
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

    @Override
    public void onBackPressed() {
        finish();
    }
}