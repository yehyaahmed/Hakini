package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailsUserActivity extends AppCompatActivity {

    TextInputEditText yearBornEditText;
    TextInputLayout textInputLayout3;
    TextView haveAccountInDetailsTV;
    Spinner sexSpinner, countrySpinner;
    Button detailsContinueBtn;

    String sexSpinnerText, countrySpinnerText;

    String token;

    ConstraintLayout detailsUserActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_user);

       /*
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
*/
        token = getIntent().getStringExtra("token");

        yearBornEditText = findViewById(R.id.yearBornEditText);
        textInputLayout3 = findViewById(R.id.textInputLayout3);
        haveAccountInDetailsTV = findViewById(R.id.haveAccountInDetailsTV);
        sexSpinner = findViewById(R.id.sexSpinner);
        countrySpinner = findViewById(R.id.countrySpinner);
        detailsContinueBtn = findViewById(R.id.detailsContinueBtn);
        detailsUserActivity = findViewById(R.id.detailsUserActivity);

        detailsUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });
        String haveAccountInDetailText = "لديك بالفعل حساب؟ " + "<b>" + "تسجيل الدخول" + "<b>";
        haveAccountInDetailsTV.setText(Html.fromHtml(haveAccountInDetailText));

        haveAccountInDetailsTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailsUserActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });
/*
        yearBornEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                textInputLayout3.setPaddingRelative(20, 8, 20, 0);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
*/
        sexSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!sexSpinner.getItemAtPosition(i).toString().equals("الجنس؟")) {
                    sexSpinnerText = sexSpinner.getItemAtPosition(i).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        List<String> countrys = Arrays.asList(getResources().getStringArray(R.array.country));
        for (int i = 0; i < countrys.size(); i++) {
            if (countrys.get(i).equalsIgnoreCase("فلسطين")) {
                countrySpinner.setSelection(i);
            }
        }

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (!countrySpinner.getItemAtPosition(i).toString().equals("الدولة")) {
                    countrySpinnerText = countrySpinner.getItemAtPosition(i).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        detailsContinueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dob = yearBornEditText.getText().toString();

                if (sexSpinnerText == null) {
                    Toast.makeText(DetailsUserActivity.this, "أدخل الجنس", Toast.LENGTH_SHORT).show();
                } else if (dob.length() != 4) {
                    Toast.makeText(DetailsUserActivity.this, "أدخل سنة الميلاد", Toast.LENGTH_SHORT).show();
                } else if (countrySpinnerText == null) {
                    Toast.makeText(DetailsUserActivity.this, "أدخل الدولة", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(DetailsUserActivity.this, ProfessionActivity.class);
                    intent.putExtra("token", token);
                    intent.putExtra("sex", sexSpinnerText);
                    intent.putExtra("country", countrySpinnerText);
                    intent.putExtra("dob", dob);
                    startActivity(intent);
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