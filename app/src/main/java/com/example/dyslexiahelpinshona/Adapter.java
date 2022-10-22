package com.example.dyslexiahelpinshona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Category> categoryList;

    public Adapter (List<Category>categoryList)
    {
        this.categoryList=categoryList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category_template,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int resource= categoryList.get(position).getImageview1();
        String name= categoryList.get(position).getTextview1();


        holder.setData(resource,name);
    }

    @Override
    public int getItemCount() {

        return categoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView= itemView.findViewById(R.id.imageview1);
            textView= itemView.findViewById(R.id.textview1);
        }

        public void setData(int resource, String name) {

            imageView.setImageResource(resource);
            textView.setText(name);
        }
    }
}
