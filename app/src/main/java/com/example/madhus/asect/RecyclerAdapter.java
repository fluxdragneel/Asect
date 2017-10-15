package com.example.madhus.asect;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Madhus on 05-08-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {
            "Timetable",
            "Subjects",
            "Faculty",
            "Resources",
            "Calendar of Events",
            };


    private String[] details = {
        "A chart showing the time at which a particular event takes place",
        "These are the subjects you have to study this semester",
        "These are the people who will teach you the skills to pay your bills",
        "This is where you'll get all the relevant textbooks, question papers,..etc",
        "This is pretty useless as it doesn't show holidays"};

    private int[] images = {
        R.drawable.timetable,
        R.drawable.subjects,
        R.drawable.faculty,
        R.drawable.resources,
        R.drawable.calendar_of_events};





    public class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);

            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position= getAdapterPosition();
                    Snackbar snackbar=Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            });
        }
    }





    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, int i) {


        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


}
