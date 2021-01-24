package com.yehyaayash99.hakini;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.yehyaayash99.hakini.Config.Config;

import org.json.JSONException;

import java.math.BigDecimal;

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

    private double payNumber;

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        payAndEndBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!soundAndVideoSeleted && !soundOlySeleted) {
                    Toast.makeText(PaymentActivity.this, "إختر خطة الدفع لو سمحت", Toast.LENGTH_SHORT).show();
                } else {
                    if (soundAndVideoSeleted) {
                        payNumber = 29.99;
                        goToPaypal(payNumber);
                    } else {
                        payNumber = 21.99;
                        goToPaypal(payNumber);
                    }
                }

            }
        });

        soundAndVideoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundAndVideoSeleted = true;
                soundOlySeleted = false;
                checkSelected();
            }
        });

        soundOnlyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundAndVideoSeleted = false;
                soundOlySeleted = true;
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
        sheetView.findViewById(R.id.doctorIV).setBackgroundResource(R.drawable.subscription_gold);
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
        sheetView.findViewById(R.id.doctorIV).setBackgroundResource(R.drawable.subscription_gold);
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
}