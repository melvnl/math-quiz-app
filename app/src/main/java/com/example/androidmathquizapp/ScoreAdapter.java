package com.example.androidmathquizapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>{

    private ArrayList<Score> scores;

    public ScoreAdapter(ArrayList<Score> scores){
        this.scores = scores;
    }


    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_score, parent,false );
        return new ScoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        Score score = scores.get(position);
        holder.tvUsername.setText(score.getScoreUsername());
        holder.tvScore.setText(score.getScoreValue());
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }



    class ScoreViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUsername, tvScore;
        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUsername = itemView.findViewById(R.id.username);
            tvScore = itemView.findViewById(R.id.score);
        }
    }
}
