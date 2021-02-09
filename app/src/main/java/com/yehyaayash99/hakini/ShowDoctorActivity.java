package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;
import com.yehyaayash99.hakini.URLClass.ApiClass;
import com.yehyaayash99.hakini.URLClass.UrlClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowDoctorActivity extends AppCompatActivity {

    Button setDateInShowDoctorBtn;

    ImageView backDoctorIV, doctorImageInShowDoctorIV, shareInShowDoctorIV,
            moreDetailsInShowDoctorBtn, instagramInShowDoctorIV,
            twitterInShowDoctorIV, facebookInShowDoctorIV;

    TextView nameDoctorInShowDoctorTV, titleDoctorInShowDoctorTV,
            countryInShowDoctorTV, descriptionInShowDoctorTV,
            specialtiesInShowDoctorTV, academeInShowDoctorTV,
            pepoleInShowDoctorTV;

    private int id;
    private int user_id;

    RequestQueue referenceQueue;

    ProgressDialog progressDialog;

    ConstraintLayout showDoctorActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_doctor);
        init();

        referenceQueue = Volley.newRequestQueue(getApplicationContext());
        id = getIntent().getIntExtra("id", 0);

        showDoctorActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });
        progressDialog = new ProgressDialog(ShowDoctorActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        showAllDetails(id);
        setDateInShowDoctorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDoctorActivity.this, CalenderActivity.class);
                intent.putExtra("id", id);
                intent.putExtra("user_id", user_id);
                startActivity(intent);
            }
        });
    }

    private void init() {
        setDateInShowDoctorBtn = findViewById(R.id.setDateInShowDoctorBtn);

        backDoctorIV = findViewById(R.id.backDoctorIV);
        doctorImageInShowDoctorIV = findViewById(R.id.doctorImageInShowDoctorIV);
        shareInShowDoctorIV = findViewById(R.id.shareInShowDoctorIV);
        moreDetailsInShowDoctorBtn = findViewById(R.id.moreDetailsInShowDoctorBtn);
        instagramInShowDoctorIV = findViewById(R.id.instagramInShowDoctorIV);
        twitterInShowDoctorIV = findViewById(R.id.twitterInShowDoctorIV);
        facebookInShowDoctorIV = findViewById(R.id.facebookInShowDoctorIV);

        nameDoctorInShowDoctorTV = findViewById(R.id.nameDoctorInShowDoctorTV);
        titleDoctorInShowDoctorTV = findViewById(R.id.titleDoctorInShowDoctorTV);
        countryInShowDoctorTV = findViewById(R.id.countryInShowDoctorTV);
        descriptionInShowDoctorTV = findViewById(R.id.descriptionInShowDoctorTV);
        specialtiesInShowDoctorTV = findViewById(R.id.specialtiesInShowDoctorTV);
        academeInShowDoctorTV = findViewById(R.id.academeInShowDoctorTV);
        pepoleInShowDoctorTV = findViewById(R.id.pepoleInShowDoctorTV);

        showDoctorActivity = findViewById(R.id.showDoctorActivity);
    }

    private void showAllDetails(int id) {
        String url = "https://www.hakini.net/api/therapist/" + id;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();
                            JSONObject object = response.getJSONObject(0);
                            nameDoctorInShowDoctorTV.setText(object.getString("author_name"));
                            String image = "https://www.hakini.net/public/img/author_images/" + object.getString("author_img");
                            Picasso.get().load(image).into(doctorImageInShowDoctorIV);
                            if (!object.getString("author_title").equalsIgnoreCase("null")) {
                                titleDoctorInShowDoctorTV.setText(object.getString("author_title"));
                            }
                            if (!object.getString("country").equalsIgnoreCase("null")) {
                                countryInShowDoctorTV.setText(object.getString("country"));
                            }
                            if (!object.getString("author_bio").equalsIgnoreCase("null")) {
                                descriptionInShowDoctorTV.setText(object.getString("author_bio"));
                            }
                            if (!object.getString("specialty").equalsIgnoreCase("null")) {
                                specialtiesInShowDoctorTV.setText(object.getString("specialty"));
                            }
                            if (!object.getString("qualification").equalsIgnoreCase("null")) {
                                academeInShowDoctorTV.setText(object.getString("qualification"));
                            }
                            if (!object.getString("role").equalsIgnoreCase("null")) {
                                pepoleInShowDoctorTV.setText(object.getString("role") + " من المرضى اختاروا هذا الإستشاري");
                            }
                            user_id = Integer.parseInt(object.getString("user_id"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
            }
        });
        referenceQueue.add(request);
    }


    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}