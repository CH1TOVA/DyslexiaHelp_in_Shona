package com.example.dyslexiahelpinshona;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    private ArrayList<QuizCategories> quizCategoriesList;

    public QuizAdapter (ArrayList<QuizCategories> quizCategoriesList, RecyclerViewInterface recyclerViewInterface)
    {
        this.quizCategoriesList = quizCategoriesList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public QuizAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.quiz_template,parent,false);
        ViewHolder viewHolder = new ViewHolder(view, recyclerViewInterface);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull QuizAdapter.ViewHolder holder, int position) {
        int resource= quizCategoriesList.get(position).getImage();
        String name= quizCategoriesList.get(position).getTitle();
        int score = quizCategoriesList.get(position).getHighscore();


        holder.setData(resource,name,score);
    }

    @Override
    public int getItemCount() {
        return quizCategoriesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView categoryHighscore;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardquiz_image);
            textView = itemView.findViewById(R.id.cardquiz_title);
            categoryHighscore = itemView.findViewById(R.id.cardquiz_highscore);

            itemView.setOnClickListener(v -> {
                if(recyclerViewInterface!=null){
                    int pos = getBindingAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.OnItemClick(pos);
                    }
                }
            });
        }

        public void setData(int resource, String name, int score) {
            imageView.setImageResource(resource);
            textView.setText(name);
            categoryHighscore.setText("Maki Hombesa: " + String.valueOf(score));
        }
    }
}
