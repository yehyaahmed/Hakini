package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yehyaayash99.hakini.Adapter.TherapistAdapter;
import com.yehyaayash99.hakini.Items.TherapistItem;
import com.yehyaayash99.hakini.URLClass.ApiClass;
import com.yehyaayash99.hakini.URLClass.UrlClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChooseTherapistActivity extends AppCompatActivity {

    TextView chooseAnotherTherapistTV;
    ImageView goToAllTherapistIV;
    RecyclerView therapistRecyclerView;
    Button continueBtn;

    List<TherapistItem> therapistItems;

    TherapistAdapter therapistAdapter;

    ProgressDialog progressDialog;

    ConstraintLayout chooseTherapistActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_therapist);
        init();

        chooseTherapistActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });

        therapistItems = new ArrayList<>();
        chooseAnotherTherapistTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseTherapistActivity.this, ShowAllTherapistActivity.class);
                startActivity(intent);
            }
        });

        goToAllTherapistIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseTherapistActivity.this, ShowAllTherapistActivity.class);
                startActivity(intent);
            }
        });

        progressDialog = new ProgressDialog(ChooseTherapistActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        if (LogInActivity.token != null) {
            getData(LogInActivity.token);
        } else {
            getData(Register2Activity.token);
        }

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TherapistAdapter.numberPostion != -1) {
                    Intent intent = new Intent(ChooseTherapistActivity.this, ShowDoctorActivity.class);
                    intent.putExtra("id", TherapistAdapter.id);
                    startActivity(intent);
                } else {
                    Toast.makeText(ChooseTherapistActivity.this, "اختر أخصائي", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void init() {
        chooseAnotherTherapistTV = findViewById(R.id.chooseAnotherTherapistTV);
        goToAllTherapistIV = findViewById(R.id.goToAllTherapistIV);
        continueBtn = findViewById(R.id.continueBtn);
        chooseTherapistActivity = findViewById(R.id.chooseTherapistActivity);

        therapistRecyclerView = findViewById(R.id.therapistRecyclerView);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        therapistRecyclerView.setLayoutManager(manager);

    }

    private void getData(String token) {
        String t = "Bearer " + token;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(UrlClass.urlUpdateUserDetails)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        ApiClass apiClass = retrofit.create(ApiClass.class);
        Call<List<TherapistItem>> call = apiClass.getTherapist(t);
        call.enqueue(new Callback<List<TherapistItem>>() {
            @Override
            public void onResponse(Call<List<TherapistItem>> call, Response<List<TherapistItem>> response) {
                List<TherapistItem> body = response.body();
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    Log.d("ttt", response.toString());

                    therapistItems.addAll(body);
                    therapistAdapter = new TherapistAdapter(ChooseTherapistActivity.this, therapistItems);
                    therapistRecyclerView.setAdapter(therapistAdapter);
                    therapistAdapter.notifyDataSetChanged();
                } else {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<TherapistItem>> call, Throwable t) {
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