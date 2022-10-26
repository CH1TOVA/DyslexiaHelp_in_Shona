package com.example.dyslexiahelpinshona;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private ArrayList<Category> categoryList;

    public Adapter (ArrayList<Category>categoryList, RecyclerViewInterface recyclerViewInterface)
    {
        this.categoryList=categoryList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_template,parent,false);
        ViewHolder viewHolder = new ViewHolder(view, recyclerViewInterface);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int resource= categoryList.get(position).getImage();
        String name= categoryList.get(position).getTitle();


        holder.setData(resource,name);
    }

    @Override
    public int getItemCount() {

        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;


        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView= itemView.findViewById(R.id.card_image);
            textView= itemView.findViewById(R.id.card_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){
                        int pos = getBindingAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.OnItemClick(pos);
                        }
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

