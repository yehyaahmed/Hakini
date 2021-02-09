package com.yehyaayash99.hakini.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.yehyaayash99.hakini.Items.TherapistItem;
import com.yehyaayash99.hakini.R;

import java.util.List;

public class TherapistAdapter extends RecyclerView.Adapter<TherapistAdapter.ViewHolder> {

    private Context context;
    private List<TherapistItem> therapistItems;

    public static int numberPostion = -1;
    public static int id;

    public TherapistAdapter(Context context, List<TherapistItem> therapistItems) {
        this.context = context;
        this.therapistItems = therapistItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.doctor_item_layout, parent, false);
        return new TherapistAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final TherapistItem item = therapistItems.get(position);

        if (therapistItems.size() - 1 == position) {
            holder.lineItemTV.setVisibility(View.GONE);
        }
        String image = "https://www.hakini.net/public/img/author_images/"+item.getAuthor_img();
        Picasso.get().load(image).into(holder.imageItemIV);

        holder.nameItemTV.setText(item.getAuthor_name());
        holder.countryItemTV.setText(item.getCountry());
        holder.detailItemTV.setText(item.getAuthor_title());

        chooseOrNot(position, holder);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberPostion = position;
                id = item.getId();
                chooseOrNot(position, holder);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return therapistItems.size();
    }

    public void filterList(List<TherapistItem> items) {
        therapistItems = items;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageItemIV, chooseItemIV;
        TextView nameItemTV, detailItemTV, countryItemTV, lineItemTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageItemIV = itemView.findViewById(R.id.imageItemIV);
            chooseItemIV = itemView.findViewById(R.id.chooseItemIV);

            nameItemTV = itemView.findViewById(R.id.nameItemTV);
            detailItemTV = itemView.findViewById(R.id.detailItemTV);
            countryItemTV = itemView.findViewById(R.id.countryItemTV);
            lineItemTV = itemView.findViewById(R.id.lineItemTV);

        }
    }

    private void chooseOrNot(int position, ViewHolder holder) {
        if (numberPostion != -1) {
            if (position == numberPostion) {
                holder.chooseItemIV.setVisibility(View.VISIBLE);

            } else {
                holder.chooseItemIV.setVisibility(View.GONE);
            }
        } else {
            holder.chooseItemIV.setVisibility(View.GONE);
        }
    }


}
