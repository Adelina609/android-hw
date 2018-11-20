package com.example.andrapp.adapter;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.andrapp.*;
import java.util.List;


public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>{

    List<Films> list;

    public FilmsAdapter(List<Films> list) {
        this.list = list;
    }

    @Override
    public FilmsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);
        return new FilmsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FilmsViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateList(List<Films> newList){

        DiffUtil.DiffResult result = DiffUtil.calculateDiff(new FilmDiffUtilCallBack(this.list, newList));
        this.list.clear();
        this.list.addAll(newList);
        result.dispatchUpdatesTo(this);
    }

    class FilmsViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView rating;
        public FilmsViewHolder(View view){
            super(view);
            image = view.findViewById(R.id.person_photo);
            name = view.findViewById(R.id.person_name);
            rating = view.findViewById(R.id.person_age);
        }

        public void bind(Films object ){
            name.setText(object.getName());
            rating.setText("rating: "+object.getRating());
            image.setImageResource(object.getImage());
        }
    }
}
