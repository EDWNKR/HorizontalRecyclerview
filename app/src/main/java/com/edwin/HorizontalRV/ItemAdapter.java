package com.edwin.HorizontalRV;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<DataModel> items;
    private Context context;

    public ItemAdapter(Context context, List<DataModel> arrayList) {
        this.context = context;
        this.items = arrayList;

    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cerita, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemAdapter.ViewHolder viewHolder, int i) {
        viewHolder.txt_title.setText(items.get(i).getTitle());
        viewHolder.txt_detail.setText(items.get(i).getDetail());
        Glide.with(context).load(items.get(i).getPoster()).into(viewHolder.image_cerita);

        viewHolder.layout_background.setBackgroundColor(Color.parseColor(items.get(i).getColor()));

    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        else
            return  items.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout layout_background;
        private TextView txt_title, txt_detail;
        private ImageView image_cerita;

        public ViewHolder(View view) {
            super(view);

            layout_background = view.findViewById(R.id.layout_background);
            txt_title = view.findViewById(R.id.txt_title);
            txt_detail = view.findViewById(R.id.txt_detail);
            image_cerita = view.findViewById(R.id.image_cerita);


        }

    }
}