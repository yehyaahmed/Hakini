package com.yehyaayash99.hakini;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.yehyaayash99.hakini.Fragment.Question10Fragment;
import com.yehyaayash99.hakini.Fragment.Question11Fragment;
import com.yehyaayash99.hakini.Fragment.Question1Fragment;
import com.yehyaayash99.hakini.Fragment.Question2Fragment;
import com.yehyaayash99.hakini.Fragment.Question3Fragment;
import com.yehyaayash99.hakini.Fragment.Question4Fragment;
import com.yehyaayash99.hakini.Fragment.Question5Fragment;
import com.yehyaayash99.hakini.Fragment.Question6Fragment;
import com.yehyaayash99.hakini.Fragment.Question7Fragment;
import com.yehyaayash99.hakini.Fragment.Question8Fragment;
import com.yehyaayash99.hakini.Fragment.Question9Fragment;


public class QuestionsActivity extends AppCompatActivity {

    Fragment fragment;
    // ViewPager questionsViewPager;
    public static TextView previousTV, nextTV;
    public static ImageView slide1IV, slide2IV, slide3IV, slide4IV, slide5IV,
            slide6IV, slide7IV, slide8IV, slide9IV, slide10IV,
            slide11IV;


    public static int positionFragment;

    public static String question1Result;
    public static String question2Result;
    public static String question3Result;
    public static String question4Result;
    public static String question5Result;
    public static String question6Result;
    public static String question7Result;
    public static String question8Result;
    public static String question9Result;
    public static String question10Result;
    public static String question11Result;

    public static int number1;
    public static int number2;
    public static int number3;
    public static int number4;
    public static int number5;
    public static int number6;
    public static int number7;
    public static int number8;
    public static int number9;
    public static int number10;

    // QuestionViewPagerAdapter adapter;

    ConstraintLayout questionsActivity;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        init();

        questionsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeKeyboard();
            }
        });
/*
        adapter = new QuestionViewPagerAdapter(QuestionsActivity.this);
        questionsViewPager.setAdapter(adapter);

        questionsViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                postionInQuestionsViewPager = position;
                makeChangeInItems(postionInQuestionsViewPager);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
*/

        positionFragment = 0;
        chamgeFragment(positionFragment);


        makeChangeInItems(positionFragment);

        previousTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionFragment > 0) {
                    positionFragment--;
                    chamgeFragment(positionFragment);


                    makeChangeInItems(positionFragment);
                }
            }
        });

        nextTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkOnNextPostion(positionFragment);

            }
        });

    }

    private void init() {
        //ViewPager
        //   questionsViewPager = findViewById(R.id.questionsViewPager);

        //TextView
        previousTV = findViewById(R.id.previousTV);
        nextTV = findViewById(R.id.nextTV);

        //ImageView
        slide1IV = findViewById(R.id.slide1IV);
        slide2IV = findViewById(R.id.slide2IV);
        slide3IV = findViewById(R.id.slide3IV);
        slide4IV = findViewById(R.id.slide4IV);
        slide5IV = findViewById(R.id.slide5IV);
        slide6IV = findViewById(R.id.slide6IV);
        slide7IV = findViewById(R.id.slide7IV);
        slide8IV = findViewById(R.id.slide8IV);
        slide9IV = findViewById(R.id.slide9IV);
        slide10IV = findViewById(R.id.slide10IV);
        slide11IV = findViewById(R.id.slide11IV);

        questionsActivity = findViewById(R.id.questionsActivity);


    }

    private void checkOnNextPostion(int postion) {
        switch (postion) {
            case 0:

                if (question1Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();

                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);

                    }

                }

                break;
            case 1:
                if (question2Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();

                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);
                    }
                }

                break;
            case 2:
                if (question3Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();

                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);
                    }
                }

                break;
            case 3:
                if (question4Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();

                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);
                    }
                }

                break;
            case 4:
                if (question5Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();

                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);
                    }
                }

                break;
            case 5:

                if (question6Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();

                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);
                    }
                }
                break;
            case 6:
                if (question7Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();

                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);
                    }
                }

                break;
            case 7:
                if (question8Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();

                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);
                    }
                }
                break;
            case 8:
                if (question9Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();

                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);
                    }
                }

                break;
            case 9:

                if (question10Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();

                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);
                    }
                }
                break;
            case 10:
                if (question11Result == null) {
                    Toast.makeText(QuestionsActivity.this, "يجب ادخال جميع الحقول", Toast.LENGTH_SHORT).show();
                } else {
                    if (positionFragment < 10) {
                        positionFragment++;
                        chamgeFragment(positionFragment);

                        makeChangeInItems(positionFragment);
                    }
                }

                break;
        }
    }

    public void chamgeFragment(int postion) {
        switch (postion) {
            case 0:
                fragment = new Question1Fragment();
                break;
            case 1:
                fragment = new Question2Fragment();

                break;
            case 2:
                fragment = new Question3Fragment();

                break;
            case 3:
                fragment = new Question4Fragment();

                break;
            case 4:
                fragment = new Question5Fragment();

                break;
            case 5:
                fragment = new Question6Fragment();

                break;
            case 6:
                fragment = new Question7Fragment();

                break;
            case 7:
                fragment = new Question8Fragment();

                break;
            case 8:
                fragment = new Question9Fragment();

                break;
            case 9:
                fragment = new Question10Fragment();

                break;
            case 10:
                fragment = new Question11Fragment();

                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
        }
    }

    private void makeChangeInItems(int postion) {

        switch (postion) {
            case 0:
                postion0();
                break;
            case 1:
                postion1();
                break;
            case 2:
                postion2();
                break;
            case 3:
                postion3();
                break;
            case 4:
                postion4();
                break;
            case 5:
                postion5();
                break;
            case 6:
                postion6();
                break;
            case 7:
                postion7();
                break;
            case 8:
                postion8();
                break;
            case 9:
                postion9();
                break;
            case 10:
                postion10();
                break;
        }

    }

    private void postion0() {

        previousTV.setTextColor(Color.parseColor("#A3FFFFFF"));
        nextTV.setTextColor(this.getResources().getColor(R.color.white));

        slide1IV.setImageResource(R.drawable.circle_slide_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion1() {

        previousTV.setTextColor(this.getResources().getColor(R.color.white));
        nextTV.setTextColor(this.getResources().getColor(R.color.white));

        slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion2() {

        previousTV.setTextColor(this.getResources().getColor(R.color.white));
        nextTV.setTextColor(this.getResources().getColor(R.color.white));

        slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion3() {

        previousTV.setTextColor(this.getResources().getColor(R.color.white));
        nextTV.setTextColor(this.getResources().getColor(R.color.white));

        slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion4() {

        previousTV.setTextColor(this.getResources().getColor(R.color.white));
        nextTV.setTextColor(this.getResources().getColor(R.color.white));

        slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion5() {

        previousTV.setTextColor(this.getResources().getColor(R.color.white));
        nextTV.setTextColor(this.getResources().getColor(R.color.white));

        slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion6() {

        previousTV.setTextColor(this.getResources().getColor(R.color.white));
        nextTV.setTextColor(this.getResources().getColor(R.color.white));

        slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion7() {

        previousTV.setTextColor(this.getResources().getColor(R.color.white));
        nextTV.setTextColor(this.getResources().getColor(R.color.white));

        slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion8() {

        previousTV.setTextColor(this.getResources().getColor(R.color.white));
        nextTV.setTextColor(this.getResources().getColor(R.color.white));

        slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion9() {

        previousTV.setTextColor(this.getResources().getColor(R.color.white));
        nextTV.setTextColor(this.getResources().getColor(R.color.white));

        slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion10() {

        previousTV.setTextColor(this.getResources().getColor(R.color.white));
        nextTV.setTextColor(Color.parseColor("#A3FFFFFF"));

        slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        slide11IV.setImageResource(R.drawable.circle_slide_check_bg);

    }
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}