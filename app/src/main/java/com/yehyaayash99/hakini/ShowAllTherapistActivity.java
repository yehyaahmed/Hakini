package com.yehyaayash99.hakini;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
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

public class ShowAllTherapistActivity extends AppCompatActivity {

    RecyclerView showAllTherapistRecyclerView;
    Button continueInAllTherapistBtn;
    EditText searchTherapistET;
    List<TherapistItem> therapistItems;
    TherapistAdapter therapistAdapter;
    ProgressDialog progressDialog;

    ConstraintLayout showAllTherapistActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_therapist);
        init();
        therapistItems = new ArrayList<>();
        progressDialog = new ProgressDialog(ShowAllTherapistActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getAllTherapist();

        showAllTherapistActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });

        continueInAllTherapistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TherapistAdapter.numberPostion != -1) {
                    Intent intent = new Intent(ShowAllTherapistActivity.this, ShowDoctorActivity.class);
                    intent.putExtra("id", TherapistAdapter.id);
                    startActivity(intent);
                } else {
                    Toast.makeText(ShowAllTherapistActivity.this, "اختر أخصائي", Toast.LENGTH_SHORT).show();
                }
            }
        });

        searchTherapistET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

    }

    private void filter(String text) {
        List<TherapistItem> items = new ArrayList<>();
        for (TherapistItem item : therapistItems){
            if (item.getAuthor_name().toLowerCase().contains(text.toLowerCase())){
                items.add(item);
            }
        }
        therapistAdapter.filterList(items);
    }

    private void init() {
        continueInAllTherapistBtn = findViewById(R.id.continueInAllTherapistBtn);
        searchTherapistET = findViewById(R.id.searchTherapistET);

        showAllTherapistActivity = findViewById(R.id.showAllTherapistActivity);

        showAllTherapistRecyclerView = findViewById(R.id.showAllTherapistRecyclerView);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        showAllTherapistRecyclerView.setLayoutManager(manager);
    }

    private void getAllTherapist() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(UrlClass.urlUpdateUserDetails)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        ApiClass apiClass = retrofit.create(ApiClass.class);
        Call<List<TherapistItem>> call = apiClass.getAllTherapist();
        call.enqueue(new Callback<List<TherapistItem>>() {
            @Override
            public void onResponse(Call<List<TherapistItem>> call, Response<List<TherapistItem>> response) {
                List<TherapistItem> body = response.body();
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    Log.d("ttt", response.toString());
                    therapistItems.addAll(body);
                    therapistAdapter = new TherapistAdapter(ShowAllTherapistActivity.this, therapistItems);
                    showAllTherapistRecyclerView.setAdapter(therapistAdapter);
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