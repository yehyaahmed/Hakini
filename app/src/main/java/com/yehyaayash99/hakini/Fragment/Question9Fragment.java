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

public class Question9Fragment extends Fragment {

    ImageView question9Choose1IV, question9Choose2IV, question9Choose3IV, question9Choose4IV, question9Choose5IV,
            question9Choose6IV, question9Choose7IV, question9Choose8IV, question9Choose9IV, question9Choose10IV,
            question9Selected1IV, question9Selected2IV, question9Selected3IV, question9Selected4IV, question9Selected5IV,
            question9Selected6IV, question9Selected7IV, question9Selected8IV, question9Selected9IV, question9Selected10IV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.question9_layout, container, false);

        init(view);
        checkSelect();

        question9Choose1IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number9 = 1;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question10Fragment()).commit();                    }
                }, 1000);
            }
        });

        question9Choose2IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number9 = 2;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question10Fragment()).commit();                    }
                }, 1000);
            }
        });

        question9Choose3IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number9 = 3;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question10Fragment()).commit();                    }
                }, 1000);
            }
        });

        question9Choose4IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number9 = 4;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question10Fragment()).commit();                    }
                }, 1000);
            }
        });

        question9Choose5IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number9 = 5;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question10Fragment()).commit();                    }
                }, 1000);
            }
        });

        question9Choose6IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number9 = 6;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question10Fragment()).commit();                    }
                }, 1000);
            }
        });

        question9Choose7IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number9 = 7;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question10Fragment()).commit();                    }
                }, 1000);
            }
        });

        question9Choose8IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number9 = 8;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question10Fragment()).commit();                    }
                }, 1000);
            }
        });

        question9Choose9IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number9 = 9;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question10Fragment()).commit();                    }
                }, 1000);
            }
        });

        question9Choose10IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionsActivity.number9 = 10;
                checkSelect();
                QuestionsActivity.positionFragment++;
                makeChangeInItems(QuestionsActivity.positionFragment);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getFragmentManager().beginTransaction().replace(R.id.fragment_container, new Question10Fragment()).commit();                    }
                }, 1000);
            }
        });


        return view;
    }

    private void checkSelect() {
        switch (QuestionsActivity.number9) {
            case 1:
                question9Selected1IV.setVisibility(View.VISIBLE);
                question9Selected2IV.setVisibility(View.GONE);
                question9Selected3IV.setVisibility(View.GONE);
                question9Selected4IV.setVisibility(View.GONE);
                question9Selected5IV.setVisibility(View.GONE);
                question9Selected6IV.setVisibility(View.GONE);
                question9Selected7IV.setVisibility(View.GONE);
                question9Selected8IV.setVisibility(View.GONE);
                question9Selected9IV.setVisibility(View.GONE);
                question9Selected10IV.setVisibility(View.GONE);


                QuestionsActivity.question9Result = "تطوير الذات";
                break;
            case 2:
                question9Selected1IV.setVisibility(View.GONE);
                question9Selected2IV.setVisibility(View.VISIBLE);
                question9Selected3IV.setVisibility(View.GONE);
                question9Selected4IV.setVisibility(View.GONE);
                question9Selected5IV.setVisibility(View.GONE);
                question9Selected6IV.setVisibility(View.GONE);
                question9Selected7IV.setVisibility(View.GONE);
                question9Selected8IV.setVisibility(View.GONE);
                question9Selected9IV.setVisibility(View.GONE);
                question9Selected10IV.setVisibility(View.GONE);

                QuestionsActivity.question9Result = "علاج نفسي عائلي / مشاكل عائلية";
                break;
            case 3:
                question9Selected1IV.setVisibility(View.GONE);
                question9Selected2IV.setVisibility(View.GONE);
                question9Selected3IV.setVisibility(View.VISIBLE);
                question9Selected4IV.setVisibility(View.GONE);
                question9Selected5IV.setVisibility(View.GONE);
                question9Selected6IV.setVisibility(View.GONE);
                question9Selected7IV.setVisibility(View.GONE);
                question9Selected8IV.setVisibility(View.GONE);
                question9Selected9IV.setVisibility(View.GONE);
                question9Selected10IV.setVisibility(View.GONE);

                QuestionsActivity.question9Result = "الاكتئاب";
                break;
            case 4:
                question9Selected1IV.setVisibility(View.GONE);
                question9Selected2IV.setVisibility(View.GONE);
                question9Selected3IV.setVisibility(View.GONE);
                question9Selected4IV.setVisibility(View.VISIBLE);
                question9Selected5IV.setVisibility(View.GONE);
                question9Selected6IV.setVisibility(View.GONE);
                question9Selected7IV.setVisibility(View.GONE);
                question9Selected8IV.setVisibility(View.GONE);
                question9Selected9IV.setVisibility(View.GONE);
                question9Selected10IV.setVisibility(View.GONE);

                QuestionsActivity.question9Result = "القلق";
                break;
            case 5:
                question9Selected1IV.setVisibility(View.GONE);
                question9Selected2IV.setVisibility(View.GONE);
                question9Selected3IV.setVisibility(View.GONE);
                question9Selected4IV.setVisibility(View.GONE);
                question9Selected5IV.setVisibility(View.VISIBLE);
                question9Selected6IV.setVisibility(View.GONE);
                question9Selected7IV.setVisibility(View.GONE);
                question9Selected8IV.setVisibility(View.GONE);
                question9Selected9IV.setVisibility(View.GONE);
                question9Selected10IV.setVisibility(View.GONE);

                QuestionsActivity.question9Result = "مشاكل في التغذية و الشهية";
                break;
            case 6:
                question9Selected1IV.setVisibility(View.GONE);
                question9Selected2IV.setVisibility(View.GONE);
                question9Selected3IV.setVisibility(View.GONE);
                question9Selected4IV.setVisibility(View.GONE);
                question9Selected5IV.setVisibility(View.GONE);
                question9Selected6IV.setVisibility(View.VISIBLE);
                question9Selected7IV.setVisibility(View.GONE);
                question9Selected8IV.setVisibility(View.GONE);
                question9Selected9IV.setVisibility(View.GONE);
                question9Selected10IV.setVisibility(View.GONE);

                QuestionsActivity.question9Result = "مشاكل في النوم";
                break;
            case 7:
                question9Selected1IV.setVisibility(View.GONE);
                question9Selected2IV.setVisibility(View.GONE);
                question9Selected3IV.setVisibility(View.GONE);
                question9Selected4IV.setVisibility(View.GONE);
                question9Selected5IV.setVisibility(View.GONE);
                question9Selected6IV.setVisibility(View.GONE);
                question9Selected7IV.setVisibility(View.VISIBLE);
                question9Selected8IV.setVisibility(View.GONE);
                question9Selected9IV.setVisibility(View.GONE);
                question9Selected10IV.setVisibility(View.GONE);

                QuestionsActivity.question9Result = "الهوية الجنسية";
                break;
            case 8:
                question9Selected1IV.setVisibility(View.GONE);
                question9Selected2IV.setVisibility(View.GONE);
                question9Selected3IV.setVisibility(View.GONE);
                question9Selected4IV.setVisibility(View.GONE);
                question9Selected5IV.setVisibility(View.GONE);
                question9Selected6IV.setVisibility(View.GONE);
                question9Selected7IV.setVisibility(View.GONE);
                question9Selected8IV.setVisibility(View.VISIBLE);
                question9Selected9IV.setVisibility(View.GONE);
                question9Selected10IV.setVisibility(View.GONE);

                QuestionsActivity.question9Result = "الوسواس القهري";
                break;
            case 9:
                question9Selected1IV.setVisibility(View.GONE);
                question9Selected2IV.setVisibility(View.GONE);
                question9Selected3IV.setVisibility(View.GONE);
                question9Selected4IV.setVisibility(View.GONE);
                question9Selected5IV.setVisibility(View.GONE);
                question9Selected6IV.setVisibility(View.GONE);
                question9Selected7IV.setVisibility(View.GONE);
                question9Selected8IV.setVisibility(View.GONE);
                question9Selected9IV.setVisibility(View.VISIBLE);
                question9Selected10IV.setVisibility(View.GONE);

                QuestionsActivity.question9Result = "الصدمة";
                break;
            case 10:
                question9Selected1IV.setVisibility(View.GONE);
                question9Selected2IV.setVisibility(View.GONE);
                question9Selected3IV.setVisibility(View.GONE);
                question9Selected4IV.setVisibility(View.GONE);
                question9Selected5IV.setVisibility(View.GONE);
                question9Selected6IV.setVisibility(View.GONE);
                question9Selected7IV.setVisibility(View.GONE);
                question9Selected8IV.setVisibility(View.GONE);
                question9Selected9IV.setVisibility(View.GONE);
                question9Selected10IV.setVisibility(View.VISIBLE);

                QuestionsActivity.question9Result = "أخر";
                break;
            default:
                question9Selected1IV.setVisibility(View.GONE);
                question9Selected2IV.setVisibility(View.GONE);
                question9Selected3IV.setVisibility(View.GONE);
                question9Selected4IV.setVisibility(View.GONE);
                question9Selected5IV.setVisibility(View.GONE);
                question9Selected6IV.setVisibility(View.GONE);
                question9Selected7IV.setVisibility(View.GONE);
                question9Selected8IV.setVisibility(View.GONE);
                question9Selected9IV.setVisibility(View.GONE);
                question9Selected10IV.setVisibility(View.GONE);

                break;
        }
    }

    private void init(View view) {
        question9Choose1IV = view.findViewById(R.id.question9Choose1IV);
        question9Choose2IV = view.findViewById(R.id.question9Choose2IV);
        question9Choose3IV = view.findViewById(R.id.question9Choose3IV);
        question9Choose4IV = view.findViewById(R.id.question9Choose4IV);
        question9Choose5IV = view.findViewById(R.id.question9Choose5IV);
        question9Choose6IV = view.findViewById(R.id.question9Choose6IV);
        question9Choose7IV = view.findViewById(R.id.question9Choose7IV);
        question9Choose8IV = view.findViewById(R.id.question9Choose8IV);
        question9Choose9IV = view.findViewById(R.id.question9Choose9IV);
        question9Choose10IV = view.findViewById(R.id.question9Choose10IV);

        question9Selected1IV = view.findViewById(R.id.question9Selected1IV);
        question9Selected2IV = view.findViewById(R.id.question9Selected2IV);
        question9Selected3IV = view.findViewById(R.id.question9Selected3IV);
        question9Selected4IV = view.findViewById(R.id.question9Selected4IV);
        question9Selected5IV = view.findViewById(R.id.question9Selected5IV);
        question9Selected6IV = view.findViewById(R.id.question9Selected6IV);
        question9Selected7IV = view.findViewById(R.id.question9Selected7IV);
        question9Selected8IV = view.findViewById(R.id.question9Selected8IV);
        question9Selected9IV = view.findViewById(R.id.question9Selected9IV);
        question9Selected10IV = view.findViewById(R.id.question9Selected10IV);

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
