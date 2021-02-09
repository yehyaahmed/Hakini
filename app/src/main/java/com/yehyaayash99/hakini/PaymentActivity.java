package com.yehyaayash99.hakini;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.squareup.picasso.Picasso;
import com.yehyaayash99.hakini.Config.Config;
import com.yehyaayash99.hakini.URLClass.ApiClass;
import com.yehyaayash99.hakini.URLClass.UpdateData;
import com.yehyaayash99.hakini.URLClass.UrlClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PaymentActivity extends AppCompatActivity {

    private static final int PAYPAL_REQUEST_CODE = 7171;

    private PayPalConfiguration payPalConfiguration = new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);

    private Button payAndEndBtn;
    private View soundAndVideoView, soundOnlyView;
    private ImageView soundAndVideoSelectedIV, soundOnlyIV;

    private boolean soundAndVideoSeleted = false;
    private boolean soundOlySeleted = false;

    ImageView doctorImageInPaymentIV;
    TextView nameDoctorPaymentTV, titleDoctorPaymentTV, countryDoctorPaymentTV,
            dayNamePaymentTV, datePaymentTV, timePaymentTV, changeDatePaymentTV, exitPaymentActivityTV;

    private double payNumber;
    private int type = 0;

    String time, timeToShow, dayName, date, cost;
    int id, therapist_id;

    RequestQueue referenceQueue;
    ProgressDialog progressDialog;

    String author_name, author_img, author_title, country;

    ConstraintLayout paymentActivity;

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        init();
        checkSelected();
        startPayPalService();
        referenceQueue = Volley.newRequestQueue(getApplicationContext());

        paymentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });
        time = getIntent().getStringExtra("time");
        timeToShow = getIntent().getStringExtra("timeToShow");
        dayName = getIntent().getStringExtra("dayName");
        date = getIntent().getStringExtra("date");
        id = getIntent().getIntExtra("id", 0);

        dayNamePaymentTV.setText(dayName);
        datePaymentTV.setText(date);
        timePaymentTV.setText(timeToShow);
        changeDatePaymentTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, CalenderActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });

        exitPaymentActivityTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, ShowDoctorActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });


        progressDialog = new ProgressDialog(PaymentActivity.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        showAllDetails(id);


        payAndEndBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentActivity.this, VideoCall.class);
                startActivity(intent);
                /*
                progressDialog = new ProgressDialog(PaymentActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

                if (!soundAndVideoSeleted && !soundOlySeleted) {
                    Toast.makeText(PaymentActivity.this, "إختر خطة الدفع لو سمحت", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                } else {
                    if (LogInActivity.token != null) {
                        saveAppointment(LogInActivity.token);
                    } else {
                        saveAppointment(Register2Activity.token);
                    }

                }
*/
            }
        });

        soundAndVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundAndVideoSeleted = true;
                soundOlySeleted = false;
                cost = "29.99";
                type = 1;
                checkSelected();
            }
        });

        soundOnlyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundAndVideoSeleted = false;
                soundOlySeleted = true;
                cost = "21.99";
                type = 2;
                checkSelected();
            }
        });

    }

    private void init() {
        payAndEndBtn = findViewById(R.id.payAndEndBtn);
        soundAndVideoView = findViewById(R.id.soundAndVideoView);
        soundOnlyView = findViewById(R.id.soundOnlyView);
        soundAndVideoSelectedIV = findViewById(R.id.soundAndVideoSelectedIV);
        soundOnlyIV = findViewById(R.id.soundOnlyIV);

        doctorImageInPaymentIV = findViewById(R.id.doctorImageInPaymentIV);
        nameDoctorPaymentTV = findViewById(R.id.nameDoctorPaymentTV);
        titleDoctorPaymentTV = findViewById(R.id.titleDoctorPaymentTV);
        countryDoctorPaymentTV = findViewById(R.id.countryDoctorPaymentTV);
        dayNamePaymentTV = findViewById(R.id.dayNamePaymentTV);
        datePaymentTV = findViewById(R.id.datePaymentTV);
        timePaymentTV = findViewById(R.id.timePaymentTV);
        changeDatePaymentTV = findViewById(R.id.changeDatePaymentTV);
        exitPaymentActivityTV = findViewById(R.id.exitPaymentActivityTV);
        paymentActivity = findViewById(R.id.paymentActivity);


    }

    private void checkSelected() {
        if (soundAndVideoSeleted) {
            soundOlySeleted = false;
            soundAndVideoView.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected_bg));
            soundAndVideoSelectedIV.setVisibility(View.VISIBLE);
        } else {
            soundAndVideoView.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.not_selected_bg));
            soundAndVideoSelectedIV.setVisibility(View.GONE);
        }

        if (soundOlySeleted) {
            soundAndVideoSeleted = false;
            soundOnlyView.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.selected_bg));
            soundOnlyIV.setVisibility(View.VISIBLE);
        } else {
            soundOnlyView.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.not_selected_bg));
            soundOnlyIV.setVisibility(View.GONE);
        }


    }

    private void startPayPalService() {
        Intent intent = new Intent(this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
        startService(intent);
    }

    private void goToPaypal(double payNumber) {
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(payNumber),
                "USD",
                "Payment",
                PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(this, com.paypal.android.sdk.payments.PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
        intent.putExtra(com.paypal.android.sdk.payments.PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                PaymentConfirmation paymentConfirmation = data.getParcelableExtra(com.paypal.android.sdk.payments.PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (paymentConfirmation != null) {
                    try {
                        String paymentDetails = paymentConfirmation.toJSONObject().toString(4);
                        showSuccessBottomSheet();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (requestCode == com.paypal.android.sdk.payments.PaymentActivity.RESULT_EXTRAS_INVALID) {
            showFailBottomSheet();
        }
    }

    private void showSuccessBottomSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PaymentActivity.this, R.style.BottomSheetTheme);
        View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.success_pay_layout,
                (ViewGroup) findViewById(R.id.successBottomSheet));
        sheetView.findViewById(R.id.successIV).setBackgroundResource(R.drawable.success);
        Picasso.get().load(author_img).into((ImageView) sheetView.findViewById(R.id.doctorIV));
        TextView nameDoctorTV = sheetView.findViewById(R.id.nameDoctorTV);
        nameDoctorTV.setText(author_name);
        TextView titleDoctorTV = sheetView.findViewById(R.id.titleDoctorTV);
        titleDoctorTV.setText(author_title);
        TextView countryDoctorTV = sheetView.findViewById(R.id.countryDoctorTV);
        countryDoctorTV.setText(country);
        TextView dayNameSuccessPayTV = sheetView.findViewById(R.id.dayNameSuccessPayTV);
        dayNameSuccessPayTV.setText(dayName);
        TextView dateSuccessPayTV = sheetView.findViewById(R.id.dateSuccessPayTV);
        dateSuccessPayTV.setText(date);
        TextView timeSuccessPayTV = sheetView.findViewById(R.id.timeSuccessPayTV);
        timeSuccessPayTV.setText(timeToShow);
        sheetView.findViewById(R.id.videoIV).setBackgroundResource(R.drawable.video);
        sheetView.findViewById(R.id.exit_bottom_sheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(sheetView);
        bottomSheetDialog.show();
    }

    private void showFailBottomSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(PaymentActivity.this, R.style.BottomSheetTheme);
        View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.fail_pay_layout,
                (ViewGroup) findViewById(R.id.failBottomSheet));

        sheetView.findViewById(R.id.successIV).setBackgroundResource(R.drawable.fail);
        Picasso.get().load(author_img).into((ImageView) sheetView.findViewById(R.id.doctorIV));
        TextView nameDoctorTV = sheetView.findViewById(R.id.nameDoctorTV);
        nameDoctorTV.setText(author_name);
        TextView titleDoctorTV = sheetView.findViewById(R.id.titleDoctorTV);
        titleDoctorTV.setText(author_title);
        TextView countryDoctorTV = sheetView.findViewById(R.id.countryDoctorTV);
        countryDoctorTV.setText(country);
        TextView dayNameSuccessPayTV = sheetView.findViewById(R.id.dayNameSuccessPayTV);
        dayNameSuccessPayTV.setText(dayName);
        TextView dateSuccessPayTV = sheetView.findViewById(R.id.dateSuccessPayTV);
        dateSuccessPayTV.setText(date);
        TextView timeSuccessPayTV = sheetView.findViewById(R.id.timeSuccessPayTV);
        timeSuccessPayTV.setText(timeToShow);
        sheetView.findViewById(R.id.videoIV).setBackgroundResource(R.drawable.video);
        sheetView.findViewById(R.id.exit_bottom_sheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(sheetView);
        bottomSheetDialog.show();
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
                            nameDoctorPaymentTV.setText(object.getString("author_name"));
                            String image = "https://www.hakini.net/public/img/author_images/" + object.getString("author_img");
                            Picasso.get().load(image).into(doctorImageInPaymentIV);
                            titleDoctorPaymentTV.setText(object.getString("author_title"));
                            countryDoctorPaymentTV.setText(object.getString("country"));
                            therapist_id = Integer.parseInt(object.getString("user_id"));

                            author_name = object.getString("author_name");
                            author_img = "https://www.hakini.net/public/img/author_images/" + object.getString("author_img");
                            author_title = object.getString("author_title");
                            country = object.getString("country");

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

    private void saveAppointment(String token) {

        String t = "Bearer " + token;
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(UrlClass.urlUpdateUserDetails)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        ApiClass apiClass = retrofit.create(ApiClass.class);
        Call<UpdateData> call = apiClass.uploadTime(t, time, date, therapist_id + "", type + "", cost);
        call.enqueue(new Callback<UpdateData>() {
            @Override
            public void onResponse(Call<UpdateData> call, retrofit2.Response<UpdateData> response) {
                if (response.isSuccessful()) {
                    UpdateData updateData = response.body();
                    if (soundAndVideoSeleted) {
                        progressDialog.dismiss();
                        payNumber = 29.99;
                        goToPaypal(payNumber);
                    } else {
                        progressDialog.dismiss();
                        payNumber = 21.99;
                        goToPaypal(payNumber);
                    }
                } else {
                    Log.d("ttt", response.toString());
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<UpdateData> call, Throwable t) {
                Log.d("ttt", t.toString());

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