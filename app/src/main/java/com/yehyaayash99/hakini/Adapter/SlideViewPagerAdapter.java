package com.yehyaayash99.hakini.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.yehyaayash99.hakini.R;
import com.yehyaayash99.hakini.RegisterActivity;

public class SlideViewPagerAdapter extends PagerAdapter {

    Context context;
    ViewPager viewPager;

    ImageView koalaIV, nextIV, firstSlideIV, secondSlideIV, imageView12, imageView14;
    TextView firstTextSlideScreen, secondTextSlideScreen;
    Button startBtn;

    public SlideViewPagerAdapter(Context context, ViewPager viewPager) {
        this.context = context;
        this.viewPager = viewPager;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_screen_layout, container, false);

        koalaIV = view.findViewById(R.id.koalaIV);
        nextIV = view.findViewById(R.id.nextIV);
        firstSlideIV = view.findViewById(R.id.firstImageSlideIV);
        secondSlideIV = view.findViewById(R.id.secondImageSlideIV);
        imageView12 = view.findViewById(R.id.imageView12);
        imageView14 = view.findViewById(R.id.imageView14);
        firstTextSlideScreen = view.findViewById(R.id.firstTextSlideScreen);
        secondTextSlideScreen = view.findViewById(R.id.secondTextSlideScreen);
        startBtn = view.findViewById(R.id.startBtn);


        switch (position) {
            case 0:
                startBtn.setVisibility(View.GONE);

                firstSlideIV.setVisibility(View.VISIBLE);
                secondSlideIV.setVisibility(View.VISIBLE);
                imageView12.setVisibility(View.GONE);
                imageView14.setVisibility(View.GONE);

                koalaIV.setImageResource(R.drawable.koala_hello);
                firstSlideIV.setImageResource(R.drawable.circle_slide_check_bg);
                secondSlideIV.setImageResource(R.drawable.circle_slide_not_check_bg);
                firstTextSlideScreen.setText("مرحباً! أنا حاكيني");
                secondTextSlideScreen.setText(
                        "سأرافقك في رحلتلك نحو صحة نفسية أفضل.\n"
                                + "سأسلك بعض الأسئلة، ثم سنقوم بتخصيص\n"
                                + "التجربة التي تلائمك.\n");

                nextIV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewPager.setCurrentItem(1);

                    }
                });
                break;

            case 1:
                nextIV.setVisibility(View.GONE);


                firstSlideIV.setVisibility(View.GONE);
                secondSlideIV.setVisibility(View.GONE);
                imageView12.setVisibility(View.VISIBLE);
                imageView14.setVisibility(View.VISIBLE);

                koalaIV.setImageResource(R.drawable.koala_relax);
                firstTextSlideScreen.setText("حاول الإسترخاء ولنبدأ");
                secondTextSlideScreen.setText(" تذكر دائماً أننا هنا لمساعدتك. لا تخجل من \nالفضفضة إلينا.");
                startBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, RegisterActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        context.startActivity(intent);
                    }
                });
                break;
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}
