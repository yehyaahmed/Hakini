package com.yehyaayash99.hakini;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.JsonObject;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;
import com.prolificinteractive.materialcalendarview.format.ArrayWeekDayFormatter;
import com.prolificinteractive.materialcalendarview.format.DateFormatDayFormatter;
import com.prolificinteractive.materialcalendarview.format.MonthArrayTitleFormatter;
import com.yehyaayash99.hakini.Adapter.TimesAdapter;
import com.yehyaayash99.hakini.Items.TherapistItem;
import com.yehyaayash99.hakini.URLClass.ApiClass;
import com.yehyaayash99.hakini.URLClass.UpdateData;
import com.yehyaayash99.hakini.URLClass.UrlClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalenderActivity extends AppCompatActivity {

    public static TextView timeTV;
    TextView acceptCalendarTV, exitCalendarTV, dayTV, dateTV, monthAndYearTV;
    ImageView goToNextMonthIV, goToOldMonthIV;

    MaterialCalendarView materialCalendarView;


    String resultTimeChoose;
    String resultTimeChooseToShow;

    Dialog dialog;

    private int id, user_id;
    String d;

    TextView yearInDialogTV, month1TV, month2TV, month3TV, month4TV, month5TV,
            month6TV, month7TV, month8TV, month9TV, month10TV,
            month11TV, month12TV;
    ImageView goToOldYearDialogIV, goToNextYearDialogIV;

    int currentYear, currentMonth;

    ConstraintLayout calenderActivity;

    RecyclerView timeRecyclerView;
    List<String> stringList;
    TimesAdapter timesAdapter;

    @SuppressLint({"NewApi", "SetTextI18n"})
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        init();
        stringList = new ArrayList<>();

        id = getIntent().getIntExtra("id", 0);
        user_id = getIntent().getIntExtra("user_id", 0);

        materialCalendarView.setTopbarVisible(false);
        materialCalendarView.setWeekDayFormatter(new ArrayWeekDayFormatter(getResources().getTextArray(R.array.custom_weekdays)));


        currentYear = materialCalendarView.getCurrentDate().getYear();
        currentMonth = materialCalendarView.getCurrentDate().getMonth();
        String monthName = getMonthName(currentMonth + 1);
        monthAndYearTV.setText(monthName + currentYear);

        materialCalendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                String monthName = getMonthName(date.getMonth() + 1);
                monthAndYearTV.setText(monthName + date.getYear());
            }
        });

        monthAndYearTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMonthDialog();
            }
        });

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                int month = date.getMonth() + 1;
                d = date.getDay() + "-" + month + "-" + date.getYear();

                getTimes(user_id, d);
                Calendar calendar = Calendar.getInstance();
                calendar.set(date.getYear(), date.getMonth(), date.getDay());
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                String[] days = new String[]{"الأحد", "الإثنين", "الثلاثاء", "الأربعاء", "الخميس", "الجمعة", "السبت"};
                String nameDay = days[dayOfWeek - 1];

                dayTV.setText(nameDay);
                dateTV.setText(d);

            }
        });


        exitCalendarTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(CalenderActivity.this, ShowDoctorActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            }
        });

        acceptCalendarTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTimeChoose = timeTV.getText().toString();
                resultTimeChooseToShow = timeTV.getText().toString();

                if (resultTimeChoose != null && !resultTimeChoose.equals("null") && !resultTimeChoose.isEmpty() &&
                        dateTV.getText() != null && !dateTV.getText().toString().equals("null") && !dateTV.getText().toString().isEmpty()) {

                    Intent intent = new Intent(CalenderActivity.this, PaymentActivity.class);
                    intent.putExtra("time", resultTimeChoose);
                    intent.putExtra("timeToShow", resultTimeChooseToShow);
                    intent.putExtra("dayName", dayTV.getText().toString());
                    intent.putExtra("date", dateTV.getText().toString());
                    intent.putExtra("id", id);
                    startActivity(intent);
                } else {
                    Toast.makeText(CalenderActivity.this, "إختر اليوم والوقت الخاص بك", Toast.LENGTH_SHORT).show();
                }

            }
        });

        goToNextMonthIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialCalendarView.goToNext();
            }
        });

        goToOldMonthIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materialCalendarView.goToPrevious();
            }
        });

/*
        CalendarView calendarView = findViewById(R.id.calendarView);

        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        String selectedDateYear = sdfYear.format(new Date(calendarView.getDate()));
        String selectedDateMonth = sdfMonth.format(new Date(calendarView.getDate()));

        Toast.makeText(this, selectedDateYear + "", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, selectedDateMonth + "", Toast.LENGTH_SHORT).show();

        if (m != Integer.parseInt(selectedDateMonth)) {
            Toast.makeText(this, "Change", Toast.LENGTH_SHORT).show();
            m = Integer.parseInt(selectedDateMonth);
        }

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                month++;
                String date = dayOfMonth + "/" + month + "/" + year;
                Toast.makeText(CalenderActivity.this, date + "", Toast.LENGTH_SHORT).show();

                Toast.makeText(CalenderActivity.this, month + "", Toast.LENGTH_SHORT).show();
                getMonthName(month);

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

                String[] days = new String[]{"الأحد", "الإثنين", "الثلاثاء", "الأربعاء", "الخميس", "الجمعة", "السبت"};
                String nameDay = days[dayOfWeek - 1];
             //   Toast.makeText(CalenderActivity.this, nameDay + "", Toast.LENGTH_SHORT).show();
            }
        });

*/
        calenderActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });
    }

    private void init() {
        materialCalendarView = findViewById(R.id.calendarView);

        acceptCalendarTV = findViewById(R.id.acceptCalendarTV);
        exitCalendarTV = findViewById(R.id.exitCalendarTV);
        dayTV = findViewById(R.id.dayTV);
        dateTV = findViewById(R.id.dateTV);
        timeTV = findViewById(R.id.timeTV);
        monthAndYearTV = findViewById(R.id.monthAndYearTV);

        goToNextMonthIV = findViewById(R.id.goToNextMonthIV);
        goToOldMonthIV = findViewById(R.id.goToOldMonthIV);

        calenderActivity = findViewById(R.id.calenderActivity);

        timeRecyclerView = findViewById(R.id.timeRecyclerView);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        timeRecyclerView.setLayoutManager(manager);

    }

    private String getMonthName(int month) {
        String[] months = new String[]{"يناير", "فبراير", "مارس", "ابريل", "مايو", "يونيو", "يوليو", "أغسطس", "سبتمبر", "أكتوبر", "نوفمبر", "ديسمبر"};
        String nameMonth = months[month - 1];
        return nameMonth;
    }


    private void showMonthDialog() {


        dialog = new Dialog(CalenderActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.month_dialog_layout);
        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setLayout(width, height);
        yearInDialogTV = dialog.findViewById(R.id.yearInDialogTV);

        yearInDialogTV.setText(materialCalendarView.getCurrentDate().getYear() + "");

        month1TV = dialog.findViewById(R.id.month1TV);
        month2TV = dialog.findViewById(R.id.month2TV);
        month3TV = dialog.findViewById(R.id.month3TV);
        month4TV = dialog.findViewById(R.id.month4TV);
        month5TV = dialog.findViewById(R.id.month5TV);
        month6TV = dialog.findViewById(R.id.month6TV);
        month7TV = dialog.findViewById(R.id.month7TV);
        month8TV = dialog.findViewById(R.id.month8TV);
        month9TV = dialog.findViewById(R.id.month9TV);
        month10TV = dialog.findViewById(R.id.month10TV);
        month11TV = dialog.findViewById(R.id.month11TV);
        month12TV = dialog.findViewById(R.id.month12TV);

        int month = materialCalendarView.getCurrentDate().getMonth();
        selectMonth(month + 1);

        goToOldYearDialogIV = dialog.findViewById(R.id.goToOldYearDialogIV);
        goToNextYearDialogIV = dialog.findViewById(R.id.goToNextYearDialogIV);

        goToOldYearDialogIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentYear--;
                yearInDialogTV.setText(currentYear + "");
            }
        });

        goToNextYearDialogIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentYear++;
                yearInDialogTV.setText(currentYear + "");

            }
        });

        dialog.show();
    }

    private int getMonthNumber(String monthName) {
        int monthNumber = 0;
        String[] months = new String[]{"يناير", "فبراير", "مارس", "ابريل", "مايو", "يونيو", "يوليو", "أغسطس", "سبتمبر", "أكتوبر", "نوفمبر", "ديسمبر"};

        for (int i = 0; i < months.length; i++) {
            if (months[i].equalsIgnoreCase(monthName)) {
                monthNumber = i++;
            }
        }

        return monthNumber;
    }

    @SuppressLint("SetTextI18n")
    public void month1Click(View view) {
        String monthName = getMonthName(1);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 0, 1));
    }

    public void month2Click(View view) {
        String monthName = getMonthName(2);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 1, 1));
    }

    public void month3Click(View view) {

        String monthName = getMonthName(3);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 2, 1));
    }

    public void month4Click(View view) {

        String monthName = getMonthName(4);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 3, 1));
    }

    public void month5Click(View view) {
        String monthName = getMonthName(5);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 4, 1));

    }

    public void month6Click(View view) {
        String monthName = getMonthName(6);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 5, 1));

    }

    public void month7Click(View view) {
        String monthName = getMonthName(7);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 6, 1));

    }

    public void month8Click(View view) {
        String monthName = getMonthName(8);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 7, 1));

    }

    public void month9Click(View view) {
        String monthName = getMonthName(9);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 8, 1));

    }

    public void month10Click(View view) {
        String monthName = getMonthName(10);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 9, 1));

    }

    public void month11Click(View view) {
        String monthName = getMonthName(11);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 10, 1));

    }

    public void month12Click(View view) {
        String monthName = getMonthName(12);
        dialog.dismiss();
        monthAndYearTV.setText(monthName + currentYear);
        materialCalendarView.setCurrentDate(CalendarDay.from(currentYear, 11, 1));

    }

    private void selectMonth(int month) {
        switch (month) {
            case 1:
                month1TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 2:
                month2TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 3:
                month3TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 4:
                month4TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 5:
                month5TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 6:
                month6TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 7:
                month7TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 8:
                month8TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 9:
                month9TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 10:
                month10TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 11:
                month11TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;

            case 12:
                month12TV.setBackground(getResources().getDrawable(R.drawable.month_choose_bg));
                break;
        }
    }

    private void getTimes(int user_id, String time) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(UrlClass.urlSignup)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ApiClass apiClass = retrofit.create(ApiClass.class);
        Call<List<String>> call = apiClass.getTimes(user_id, 1, time);
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                stringList.clear();
                if (response.isSuccessful()) {
                    List<String> list = response.body();
                    stringList.addAll(list);
                    timesAdapter = new TimesAdapter(CalenderActivity.this, stringList);
                    timeRecyclerView.setAdapter(timesAdapter);
                    timesAdapter.notifyDataSetChanged();
                    Log.d("tttt","true");
                }else {
                    Log.d("tttt","false");
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                Log.d("tttt", t.toString());
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