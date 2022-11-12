package com.example.dyslexiahelpinshona;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LearnAdapter extends RecyclerView.Adapter<LearnAdapter.ViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private ArrayList<LearnCategories> learncategoryList;

    public LearnAdapter(ArrayList<LearnCategories>learncategoryList, RecyclerViewInterface recyclerViewInterface)
    {
        this.learncategoryList=learncategoryList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public LearnAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.learn_template,parent,false);
        ViewHolder viewHolder = new ViewHolder(view, recyclerViewInterface);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LearnAdapter.ViewHolder holder, int position) {

        int resource= learncategoryList.get(position).getImage();
        String name= learncategoryList.get(position).getTitle();

        holder.setData(resource,name);
    }

    @Override
    public int getItemCount() {

        return learncategoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView= itemView.findViewById(R.id.card_image);
            textView= itemView.findViewById(R.id.card_title);

            itemView.setOnClickListener(v -> {
                if (recyclerViewInterface != null){
                    int pos = getBindingAdapterPosition();

                    if(pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.OnItemClick(pos);
                    }
                }
            });

        }

        public void setData(int resource, String name) {

            imageView.setImageResource(resource);
            textView.setText(name);
        }

        }
    }

