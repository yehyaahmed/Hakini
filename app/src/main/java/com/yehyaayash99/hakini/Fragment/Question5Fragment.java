package com.yehyaayash99.hakini.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yehyaayash99.hakini.QuestionsActivity;
import com.yehyaayash99.hakini.R;

public class Question5Fragment extends Fragment {

    ImageView question5Choose1IV, question5Choose2IV,
            question5Selected1IV, question5Selected2IV;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question5_layout, container, false);

        init(view);

        checkSelect();

        question5Choose1IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number5 = 1;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question6Fragment()).commit();                    }
                }, 1000);
            }
        });

        question5Choose2IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number5 = 2;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question6Fragment()).commit();                    }
                }, 1000);
            }
        });

        return view;
    }

    private void checkSelect() {
        switch (QuestionsActivity.number5) {
            case 1:
                question5Selected1IV.setVisibility(View.VISIBLE);
                question5Selected2IV.setVisibility(View.GONE);


                QuestionsActivity.question5Result = "نعم";
                break;
            case 2:
                question5Selected1IV.setVisibility(View.GONE);
                question5Selected2IV.setVisibility(View.VISIBLE);

                QuestionsActivity.question5Result = "لا";
                break;
            default:
                question5Selected1IV.setVisibility(View.GONE);
                question5Selected2IV.setVisibility(View.GONE);

                break;
        }
    }

    private void init(View view) {
        question5Choose1IV = view.findViewById(R.id.question5Choose1IV);
        question5Choose2IV = view.findViewById(R.id.question5Choose2IV);
        question5Selected1IV = view.findViewById(R.id.question5Selected1IV);
        question5Selected2IV = view.findViewById(R.id.question5Selected2IV);
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

        QuestionsActivity.previousTV.setTextColor(Color.parseColor("#A3FFFFFF"));
        QuestionsActivity.nextTV.setTextColor(this.getResources().getColor(R.color.white));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion1() {

        QuestionsActivity.previousTV.setTextColor(this.getResources().getColor(R.color.white));
        QuestionsActivity.nextTV.setTextColor(this.getResources().getColor(R.color.white));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion2() {

        QuestionsActivity.previousTV.setTextColor(this.getResources().getColor(R.color.white));
        QuestionsActivity.nextTV.setTextColor(this.getResources().getColor(R.color.white));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion3() {

        QuestionsActivity.previousTV.setTextColor(this.getResources().getColor(R.color.white));
        QuestionsActivity.nextTV.setTextColor(this.getResources().getColor(R.color.white));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion4() {

        QuestionsActivity.previousTV.setTextColor(this.getResources().getColor(R.color.white));
        QuestionsActivity.nextTV.setTextColor(this.getResources().getColor(R.color.white));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion5() {

        QuestionsActivity.previousTV.setTextColor(this.getResources().getColor(R.color.white));
        QuestionsActivity.nextTV.setTextColor(this.getResources().getColor(R.color.white));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion6() {

        QuestionsActivity.previousTV.setTextColor(this.getResources().getColor(R.color.white));
        QuestionsActivity.nextTV.setTextColor(this.getResources().getColor(R.color.white));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion7() {

        QuestionsActivity.previousTV.setTextColor(this.getResources().getColor(R.color.white));
        QuestionsActivity.nextTV.setTextColor(this.getResources().getColor(R.color.white));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion8() {

        QuestionsActivity.previousTV.setTextColor(this.getResources().getColor(R.color.white));
        QuestionsActivity.nextTV.setTextColor(this.getResources().getColor(R.color.white));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion9() {

        QuestionsActivity.previousTV.setTextColor(this.getResources().getColor(R.color.white));
        QuestionsActivity.nextTV.setTextColor(this.getResources().getColor(R.color.white));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_not_check_bg);

    }

    private void postion10() {

        QuestionsActivity.previousTV.setTextColor(this.getResources().getColor(R.color.white));
        QuestionsActivity.nextTV.setTextColor(Color.parseColor("#A3FFFFFF"));

        QuestionsActivity.slide1IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide2IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide3IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide4IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide5IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide6IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide7IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide8IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide9IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide10IV.setImageResource(R.drawable.circle_slide_not_check_bg);
        QuestionsActivity.slide11IV.setImageResource(R.drawable.circle_slide_check_bg);

    }
}
