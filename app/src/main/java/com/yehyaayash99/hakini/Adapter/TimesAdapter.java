package com.yehyaayash99.hakini.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yehyaayash99.hakini.CalenderActivity;
import com.yehyaayash99.hakini.R;

import java.util.List;

public class TimesAdapter extends RecyclerView.Adapter<TimesAdapter.ViewHolder> {

    private Context context;
    private List<String> stringList;
    String time="null";

    public TimesAdapter(Context context, List<String> stringList) {
        this.context = context;
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.time_item_layout, parent, false);
        return new TimesAdapter.ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final String item = stringList.get(position);
        holder.timeBtn.setText(item + "");
        chooseOrNot(item, holder);
        holder.timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time = item;
                chooseOrNot(item, holder);
                notifyDataSetChanged();
                CalenderActivity.timeTV.setText(item + "");

            }
        });
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        Button timeBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            timeBtn = itemView.findViewById(R.id.timeBtn);
        }
    }

    private void chooseOrNot(String item, TimesAdapter.ViewHolder holder) {
        if (!this.time.equalsIgnoreCase("null")) {
            if (this.time.equalsIgnoreCase(item)) {
                holder.timeBtn.setBackground(context.getResources().getDrawable(R.drawable.choose_time_bg));
                holder.timeBtn.setTextColor(context.getResources().getColor(R.color.white));

            } else {
                holder.timeBtn.setBackground(context.getResources().getDrawable(R.drawable.not_choose_time_bg));
                holder.timeBtn.setTextColor(context.getResources().getColor(R.color.black));
            }
        } else {
            holder.timeBtn.setBackground(context.getResources().getDrawable(R.drawable.not_choose_time_bg));
            holder.timeBtn.setTextColor(context.getResources().getColor(R.color.black));
        }
    }
}
